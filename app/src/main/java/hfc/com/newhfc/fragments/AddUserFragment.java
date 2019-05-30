package hfc.com.newhfc.fragments;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import hfc.com.newhfc.R;
import hfc.com.newhfc.activities.AddUserActivity;
import hfc.com.newhfc.activities.MainActivity;
import hfc.com.newhfc.model.adduser.AddUserRequest;
import hfc.com.newhfc.model.adduser.AddUserResponse;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.AppUtils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFMPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private static final int TAKE_PHOTO_CODE = 101;
    ImageView img_profile;
    private EditText editTextFirstname, editTextLastname,
            editTextPhone, editTextEmail, editDOB,
            editTextAddress, editTextPincode;
    private Button buttonSubmit;
    private String encodedImage;


    public AddUserFragment() {
        // Required empty public constructor
    }

    public static AddUserFragment newInstance() {
        AddUserFragment fragment = new AddUserFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        img_profile = view.findViewById(R.id.img_profile);


        getActivity().setTitle("Add User");

        editTextFirstname = view.findViewById(R.id.edittext_firstname);
        editTextLastname = view.findViewById(R.id.edittext_lastname);
        editTextPhone = view.findViewById(R.id.edittext_phonenumber);
        editTextEmail = view.findViewById(R.id.edittext_email);
        editTextAddress = view.findViewById(R.id.edittext_address);
        editDOB = view.findViewById(R.id.dob);
        editTextPincode = view.findViewById(R.id.edittext_pincode);

        buttonSubmit = view.findViewById(R.id.btn_submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });

        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
//                } else {
//                    checkPermission(true);
//                }
            }
        });
        return view;
    }

    private void checkPermission(boolean forStorage) {
        if (!forStorage) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);

        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 102);

        }

    }

    private String encodeImage(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encImage;
    }

    private void Validation() {

        boolean check = true;
        String Licreg = "434";
        String firstname = editTextFirstname.getText().toString().trim();
        String lastname = editTextLastname.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String dob = editDOB.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String pincode = editTextPincode.getText().toString().trim();

        if (firstname.isEmpty()) {
            editTextFirstname.setError("Field can't be empty");
            check = false;

        }

        if (lastname.isEmpty()) {
            editTextLastname.setError("Field can't be empty");
            check = false;

        }

        if (phone.isEmpty()) {
            editTextPhone.setError("Field can't be empty");
            check = false;

        }


        if (dob.isEmpty()) {
            editDOB.setError("Field can't be empty");
            check = false;

        }

        if (address.isEmpty()) {
            editTextAddress.setError("Field can't be empty");
            check = false;

        }
        if (pincode.isEmpty()) {
            editTextPincode.setError("Field can't be empty");
            check = false;

        }


        if (check == true) {
            //TODO add user request


            final AddUserRequest addUserRequest = new AddUserRequest();

            addUserRequest.setFirstName(firstname);
            addUserRequest.setLastName(lastname);
            addUserRequest.setAddress(address);
            try {
                addUserRequest.setDateOfBirth(dob);
            } catch (Exception e) {
                e.printStackTrace();
            }

            addUserRequest.setEmail(email);
            addUserRequest.setPincode(pincode);
            addUserRequest.setPhoneNumber(phone);
            addUserRequest.setBase64File("");
            addUserRequest.setUserName("");
            addUserRequest.setPassword("");
            String myReferalCode = HFMPrefs.getString(getActivity(), Constants.REFERAL);
            addUserRequest.setReferalCode(myReferalCode);

/*

            if (getActivity() instanceof AddUserActivity) {
                addUser.setReferalCode(((AddUserActivity) getActivity()).referalCode);
            } else {
                addUser.setReferalCode(myReferalCode);
            }
*/

            if (AppUtils.isInternetConnected(getActivity())) {
                AppUtils.showProgressDialog(getActivity());
                RestClient.addUser(addUserRequest, new Callback<AddUserResponse>() {
                    @Override
                    public void onResponse(Call<AddUserResponse> call, Response<AddUserResponse> response) {
                        AppUtils.dismissProgressDialog();
                        if (response.body() != null) {
                            if (response.body().getStatus()) {
                                AddUserResponse addUserResponse = response.body();
                                if (addUserResponse.getId() > 0) {
                                    Toast.makeText(getActivity(), "Registration Successfully", Toast.LENGTH_SHORT).show();
                                    if (getActivity() instanceof AddUserActivity) {
                                        getActivity().finish();
                                    } else {
                                        ((MainActivity) getActivity()).replaceFragment(new DashboardFragment());

                                    }
                                }

                            }
                        }


                    }

                    @Override
                    public void onFailure(Call<AddUserResponse> call, Throwable t) {

                        AppUtils.dismissProgressDialog();
                        Toast.makeText(getActivity(), R.string.response_failed, Toast.LENGTH_SHORT).show();

                    }
                });

            } else {
                AppUtils.dismissProgressDialog();
                Toast.makeText(getActivity(), R.string.Internet_failed, Toast.LENGTH_SHORT).show();
            }
        }
        /*    RestClient.addUser(access_token, addUser, new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    AppUtils.dismissProgressDialog();
                    if (response.body() != null) {

                        ResponseBody responseBody = response.body();
                        try {
                            String responseStringData = responseBody.string();
                            JSONObject jsonObject = new JSONObject(responseStringData);
                            if (Integer.parseInt(jsonObject.getString("UserId")) > 0) {
                                Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_LONG).show();
                                if (getActivity() instanceof AddUserActivity) {
                                    getActivity().finish();
                                } else {
                                    ((MainActivity) getActivity()).replaceFragment(new DashboardFragment());

                                }
                            } else {

                                Toast.makeText(getActivity(), jsonObject.getString("Message"), Toast.LENGTH_LONG).show();

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    AppUtils.dismissProgressDialog();

                }
            });*/


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            checkPermission(true);
        } else if (requestCode == 102) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            final Uri imageUri = data.getData();
            final InputStream imageStream;
            try {
                imageStream = getActivity().getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                encodedImage = encodeImage(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
