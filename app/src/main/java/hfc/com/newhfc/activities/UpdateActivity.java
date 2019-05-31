package hfc.com.newhfc.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import hfc.com.newhfc.R;
import hfc.com.newhfc.model.login.LoginResponse;
import hfc.com.newhfc.model.updateUser.UpdateUserDetail;
import hfc.com.newhfc.model.updateUser.UpdateUserResponse;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.AppUtils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFMPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
    private EditText firstname, lastName, phoneNumber, email, dob, address, pinCode;
    private Button submit;

    LoginResponse loginResponse;

    String fname, lname, phone, emailId, dateofBirth, adress, pincode;
    String userId;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        String data = HFMPrefs.getString(getApplicationContext(), Constants.LOGIN_DATA);
        loginResponse = new Gson().fromJson(data, LoginResponse.class);


        firstname = findViewById(R.id.et_firstname);
        lastName = findViewById(R.id.et_lastname);
        phoneNumber = findViewById(R.id.et_phonenumber);
        email = findViewById(R.id.et_email);
        dob = findViewById(R.id.et_dob);
        address = findViewById(R.id.et_address);
        pinCode = findViewById(R.id.et_pincode);
        submit = findViewById(R.id.btn_submit);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        if (loginResponse.getFirstName() != null) {
            firstname.setText("" + loginResponse.getFirstName());
        }
        if (loginResponse.getLastName() != null) {
            lastName.setText("" + loginResponse.getLastName());
        }
        if (loginResponse.getPhoneNumber() != null) {
            phoneNumber.setText("" + loginResponse.getPhoneNumber());
        }
        if (loginResponse.getEmail() != null) {
            email.setText("" + loginResponse.getEmail());
        }
        if (loginResponse.getDateOfBirth() != null) {
            dob.setText("" + loginResponse.getDateOfBirth());
        }
        if (loginResponse.getAddress() != null) {
            address.setText("" + loginResponse.getAddress());
        }
        if (loginResponse.getPincode() != null) {
            pinCode.setText("" + loginResponse.getPincode());
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateData();
            }
        });


    }

    private void updateData() {
        boolean check = true;

        fname = firstname.getText().toString().trim();
        lname = lastName.getText().toString().trim();
        phone = phoneNumber.getText().toString().trim();
        emailId = email.getText().toString().trim();
        dateofBirth = dob.getText().toString().trim();
        adress = address.getText().toString().trim();
        pincode = pinCode.getText().toString().trim();


        if (fname.isEmpty()) {
            firstname.setError("Field can't be empty");
            check = false;

        }

        if (lname.isEmpty()) {
            lastName.setError("Field can't be empty");
            check = false;

        }

        if (phone.isEmpty()) {
            phoneNumber.setError("Field can't be empty");
            check = false;

        }


        if (emailId.isEmpty()) {
            email.setError("Field can't be empty");
            check = false;

        }

        if (dateofBirth.isEmpty()) {
            dob.setError("Field can't be empty");
            check = false;

        }
        if (adress.isEmpty()) {
            address.setError("Field can't be empty");
            check = false;

        }
        if (pincode.isEmpty()) {
            pinCode.setError("Field can't be empty");
            check = false;
        }
        if (check == true) {
            userId = HFMPrefs.getString(UpdateActivity.this, Constants.USER_ID);

            UpdateUserDetail updateUserDetail = new UpdateUserDetail();
            updateUserDetail.setFirstName(fname);
            updateUserDetail.setLastName(lname);
            updateUserDetail.setEmail(emailId);
            updateUserDetail.setDateOfBirth(dateofBirth);
            updateUserDetail.setAddress(adress);
            updateUserDetail.setBase64File("");
            updateUserDetail.setUserId(Integer.parseInt(userId));
            updateUserDetail.setPincode(pincode);

            if (AppUtils.isInternetConnected(this)) {
                AppUtils.showProgressDialog(this);
                RestClient.updateUser(updateUserDetail, new Callback<UpdateUserResponse>() {
                    @Override
                    public void onResponse(Call<UpdateUserResponse> call, Response<UpdateUserResponse> response) {

                        AppUtils.dismissProgressDialog();
                        if (response.body() != null) {
                            if (response.body().getStatus()) {
                                UpdateUserResponse updateUserResponse = response.body();
                                    Toast.makeText(UpdateActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(UpdateActivity.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();

                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<UpdateUserResponse> call, Throwable t) {
                        AppUtils.dismissProgressDialog();
                        Toast.makeText(UpdateActivity.this, R.string.response_failed, Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                AppUtils.dismissProgressDialog();
                Toast.makeText(UpdateActivity.this, R.string.response_failed, Toast.LENGTH_SHORT).show();

        if (getSupportActionBar() != null) {
            }

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        }




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
      /*  if (item.getItemId() == R.id.edit_user) {
            Intent intent = new Intent(UpdateActivity.this, UpdateActivity.class);
            startActivity(intent);
            return true;
        }*/
        return super.onOptionsItemSelected(item);


    }

}
