package hfc.com.newhfc.fragments;


import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Calendar;

import hfc.com.newhfc.R;
import hfc.com.newhfc.activities.AddUserActivity;
import hfc.com.newhfc.activities.MainActivity;
import hfc.com.newhfc.model.adduser.AddUserRequest;
import hfc.com.newhfc.model.adduser.AddUserResponse;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.Utils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFMPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private static final int TAKE_PHOTO_CODE = 101;
    ImageView img_profile;
    private EditText editTextFirstname, editTextLastname,
            editTextPhone, editTextEmail, editDOB,
            editTextAddress, editTextPincode, editTextUsername;

    AddUserActivity addUserActivity;
    AddUserResponse addUserResponse;
    private TextView mTv;
    //private Button mbtn;
    private Calendar c;
    private DatePickerDialog dp;

    private Button buttonSubmit;
    private String encodedImage;
    String myReferalCode;


    public AddUserFragment() {
        // Required empty public constructor
    }

    public static AddUserFragment newInstance() {
        AddUserFragment fragment = new AddUserFragment();

        return fragment;
    }

/*
      if (addUserActivity. != null){
     addUserActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addUserActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
    }*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        img_profile = view.findViewById(R.id.img_profile);
        editDOB = view.findViewById(R.id.dob);
        // mTv=findViewById(R.id.textview);
        //mbtn=findViewById(R.id.btnPick);

        //show toolbar
        getActivity().setTitle("Add User");


        editTextUsername = view.findViewById(R.id.edittext_username);
        editTextFirstname = view.findViewById(R.id.edittext_firstname);
        editTextLastname = view.findViewById(R.id.edittext_lastname);
        editTextPhone = view.findViewById(R.id.edittext_phonenumber);
        editTextEmail = view.findViewById(R.id.edittext_email);
        editTextAddress = view.findViewById(R.id.edittext_address);
        editDOB = view.findViewById(R.id.dob);
        editTextPincode = view.findViewById(R.id.edittext_pincode);
        buttonSubmit = view.findViewById(R.id.btn_submit);

      /*  editDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment datePickerFragment=new DatePickerFragment();
                datePickerFragment.show(getFragmentManager(),"date Picker");

            }
        });
*/


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });


        editDOB.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dp = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        editDOB.setText(year + "-" + (month + 1) + "-" + day);

                    }
                }, day, year, month);
                dp.show();
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
        String username = editTextUsername.getText().toString().trim();

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

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError(getString(R.string.invalid_email));
            Toast.makeText(addUserActivity, R.string.invalid_email, Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(phone)) {
            editTextPhone.setError(getString(R.string.invalid_email));
            return;
        } else {
            if (phone.length() < 10) {
                editTextPhone.setError(getString(R.string.valid_phone));
                return;
            }
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
        if (username.isEmpty()) {
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
                Toast.makeText(addUserActivity, "Correct your Date Format", Toast.LENGTH_SHORT).show();
            }

            addUserRequest.setEmail(email);
            addUserRequest.setPincode(pincode);
            addUserRequest.setPhoneNumber(phone);
            addUserRequest.setBase64File("");
            addUserRequest.setUserName(username);
            addUserRequest.setPassword("");
            if (addUserActivity.referalCode != null) {
                myReferalCode = addUserActivity.referalCode;
            } else {
                myReferalCode = HFMPrefs.getString(getActivity(), Constants.REFERAL);
            }

            addUserRequest.setReferalCode(myReferalCode);

       /*
            if (getActivity() instanceof AddUserActivity) {
                addUser.setReferalCode(((AddUserActivity) getActivity()).referalCode);
            } else {
                addUser.setReferalCode(myReferalCode);
            }
*/

            if (Utils.isInternetConnected(getActivity())) {
                Utils.showProgressDialog(getActivity());
                RestClient.addUser(addUserRequest, new Callback<AddUserResponse>() {
                    @Override
                    public void onResponse(Call<AddUserResponse> call, Response<AddUserResponse> response) {
                        Utils.dismissProgressDialog();
                        if (response.body() != null) {
                            if (!(response.body().getStatus())) {
                                Toast.makeText(addUserActivity, "You Can Add Only 3 Users", Toast.LENGTH_SHORT).show();
                                if (getActivity() instanceof AddUserActivity) {
                                    getActivity().finish();
                                } else {
                                    ((MainActivity) getActivity()).replaceFragment(new DashboardFragment());

                                }
                            }

                            if (response.body().getStatus()) {
                                addUserResponse = response.body();
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

                        Utils.dismissProgressDialog();
                        Toast.makeText(addUserActivity, "Check Your Details", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), R.string.response_failed, Toast.LENGTH_SHORT).show();

                    }
                });

            } else {
                Utils.dismissProgressDialog();
                Toast.makeText(getActivity(), R.string.Internet_failed, Toast.LENGTH_SHORT).show();
            }
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
        addUserActivity = (AddUserActivity) getActivity();

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());


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
