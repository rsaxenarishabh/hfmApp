package hfc.com.newhfc.activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Calendar;

import hfc.com.newhfc.R;
import hfc.com.newhfc.model.login.LoginResponse;
import hfc.com.newhfc.model.updateUser.UpdateUserDetail;
import hfc.com.newhfc.model.updateUser.UpdateUserResponse;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.Utils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFMPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
    private EditText firstname, lastName, phoneNumber, email, dob, address, pinCode;
    private Button submit;
    private Calendar c;
    private DatePickerDialog dp;
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
        dob = findViewById(R.id.edittext_dob);
        address = findViewById(R.id.et_address);
        pinCode = findViewById(R.id.et_pincode);
        submit = findViewById(R.id.btn_submit);

        dob.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dp = new DatePickerDialog(UpdateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        dob.setText(year + "-" + (month + 1) + "-" + day);
                    }
                }, day, year, month);
                dp.show();
            }
        });

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
        if (!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()) {
            email.setError(getString(R.string.invalid_email));
            Toast.makeText(UpdateActivity.this, R.string.invalid_email, Toast.LENGTH_SHORT).show();
            check = false;
        }

        if (TextUtils.isEmpty(phone)) {
            phoneNumber.setError(getString(R.string.invalid_email));
            check = false;
        } else {
            if (phone.length() < 10) {
                phoneNumber.setError(getString(R.string.valid_phone));
                check = false;
            }
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
        if (pincode.length() < 6) {
            pinCode.setError("Field can't be empty");
            check = false;
        }
        if (check == true) {
            userId = HFMPrefs.getString(UpdateActivity.this, Constants.USER_ID);
            UpdateUserDetail updateUserDetail = new UpdateUserDetail();
            updateUserDetail.setFirstName(fname);
            updateUserDetail.setLastName(lname);
            updateUserDetail.setEmail(emailId);
            try {
                updateUserDetail.setDateOfBirth(dateofBirth);
            } catch (Exception e) {
                e.printStackTrace();
            }
            updateUserDetail.setAddress(adress);
            updateUserDetail.setPhoneNumber(phone);
            updateUserDetail.setBase64File("");
            updateUserDetail.setUserId(Integer.parseInt(userId));
            updateUserDetail.setPincode(pincode);

            if (Utils.isInternetConnected(this)) {
                Utils.showProgressDialog(this);
                RestClient.updateUser(updateUserDetail, new Callback<UpdateUserResponse>() {
                    @Override
                    public void onResponse(Call<UpdateUserResponse> call, Response<UpdateUserResponse> response) {
                        Utils.dismissProgressDialog();
                        if (response.body() != null) {
                            if (response.body().getStatus()) {
                                UpdateUserResponse updateUserResponse = response.body();
                                Toast.makeText(UpdateActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                                HFMPrefs.putString(UpdateActivity.this, Constants.LOGIN_DATA, new Gson().toJson(updateUserResponse));

                                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();


                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<UpdateUserResponse> call, Throwable t) {
                        Utils.dismissProgressDialog();
                        Toast.makeText(UpdateActivity.this, R.string.response_failed, Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Utils.dismissProgressDialog();
                Toast.makeText(UpdateActivity.this, R.string.response_failed, Toast.LENGTH_SHORT).show();


            }

        }
        if (getSupportActionBar() != null) {


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
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
