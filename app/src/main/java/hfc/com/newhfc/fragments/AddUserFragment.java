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
import android.support.v4.content.ContextCompat;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import butterknife.internal.Utils;
import hfc.com.newhfc.R;
import hfc.com.newhfc.activities.AddUserActivity;
import hfc.com.newhfc.activities.LoginActivity;
import hfc.com.newhfc.activities.MainActivity;
import hfc.com.newhfc.activities.UserListActivity;
import hfc.com.newhfc.model.adduser.AccountDetail;
import hfc.com.newhfc.model.adduser.AddUser;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.AppUtils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFCPrefs;
import okhttp3.ResponseBody;
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
    private EditText editTextLIC, editTextFirstname, editTextLastname,
            editTextPhone, editTextEmail, editDOB,
            editTextAddress, editTextPincode, editTextAadharcard, editTextPancard,
            editTextAccountnum, editTextIfsccode, editTextAccountholder,
            editTextBranchname, editTextAdharNominee, editTextNomineename, editTextJoiningfee;
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
        editTextAadharcard = view.findViewById(R.id.edittext_aadharcard);
        editTextPancard = view.findViewById(R.id.editext_pancard);
        editTextAccountnum = view.findViewById(R.id.edittext_accountnumber);
        editTextIfsccode = view.findViewById(R.id.editext_ifsc);
        editTextBranchname = view.findViewById(R.id.edittext_branch_name);
        editTextAccountholder = view.findViewById(R.id.edittext_accountholder);
        editTextAdharNominee = view.findViewById(R.id.edittext_nomineeAdhar);

        buttonSubmit = view.findViewById(R.id.button);

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
        String date = editDOB.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String pincode = editTextPincode.getText().toString().trim();
        String aadharNumber = editTextAadharcard.getText().toString().trim();
        String pancard = editTextPancard.getText().toString().trim();
        String accountnum = editTextAccountnum.getText().toString().trim();
        String ifsccode = editTextIfsccode.getText().toString().trim();
        String accountholdername = editTextAccountholder.getText().toString().trim();
        String branchname = editTextBranchname.getText().toString().trim();
        String aadharcardnumber = editTextAdharNominee.getText().toString().trim();
        String nomineedate = "N/A";
        //String joiningfees=editTextJoiningfee.getText().toString().trim();


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


        if (date.isEmpty()) {
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
        if (aadharNumber.isEmpty()) {
            editTextAccountnum.setError("Field can't be empty");
            check = false;

        }
        if (pancard.isEmpty()) {
            editTextPancard.setError("Field can't be empty");
            check = false;

        }
        if (accountnum.isEmpty()) {
            editTextAccountnum.setError("Field can't be empty");
            check = false;

        }
        if (ifsccode.isEmpty()) {
            editTextIfsccode.setError("Field can't be empty");
            check = false;

        }
        if (accountholdername.isEmpty()) {
            editTextAccountholder.setError("Field can't be empty");
            check = false;

        }
        if (branchname.isEmpty()) {
            editTextBranchname.setError("Field can't be empty");
            check = false;

        }
        if (aadharcardnumber.isEmpty()) {
            editTextAdharNominee.setError("Field can't be empty");
            check = false;

        }


        if (check == true) {
            //TODO add user request

            AddUser addUser = new AddUser();
            addUser.setFirstName(firstname);
            addUser.setLastName(lastname);
            addUser.setPhoneNumber(phone);
            addUser.setEmailAddress(email);
            addUser.setAddress(address);
            addUser.setPinCode(pincode);
            addUser.setPassword("HFC"+phone.substring(0,4));
            String myReferalCode = HFCPrefs.getString(getActivity(), Constants.REFERRAL_CODE);
            if (getActivity() instanceof AddUserActivity) {
                addUser.setReferalCode(((AddUserActivity) getActivity()).referalCode);
            } else {
                addUser.setReferalCode(myReferalCode);
            }

            addUser.setNomineeAadhar(editTextAdharNominee.getText().toString().trim());
            addUser.setNomineeDOB(editDOB.getText().toString().trim());
            AccountDetail accountDetail = new AccountDetail();
            accountDetail.setAadharNumber(editTextAadharcard.getText().toString().trim());
            accountDetail.setPancardNumber(editTextPancard.getText().toString().trim());
            accountDetail.setAccountNumber(editTextAccountnum.getText().toString().trim());
            accountDetail.setIFSCCode(editTextIfsccode.getText().toString().trim());
            accountDetail.setAccountHolderName(editTextAccountholder.getText().toString().trim());
            accountDetail.setBranchName(editTextBranchname.getText().toString().trim());

//            accountDetail.setCVV(Integer.parseInt(etCVV.getEditText().getText().toString().trim()));

            addUser.setAccountDetail(accountDetail);


            String access_token = HFCPrefs.getString(getActivity(), Constants.ACCESS_TOKEN);
            AppUtils.showProgressDialog(getActivity());
            RestClient.addUser(access_token, addUser, new Callback<ResponseBody>() {
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
            });

        } else {
            Toast.makeText(getActivity(), "Please Fill All Data completed", Toast.LENGTH_SHORT).show();
        }


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
