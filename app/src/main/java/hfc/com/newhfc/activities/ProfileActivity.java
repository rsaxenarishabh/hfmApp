package hfc.com.newhfc.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import hfc.com.newhfc.R;
import hfc.com.newhfc.model.login.LoginResponse;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFMPrefs;

public class ProfileActivity extends AppCompatActivity {
    private ImageView profileImg;
    private TextView name, userName, gmail, phone, address, pinCode, dob, email, logout;


    LoginResponse loginResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logout = findViewById(R.id.log_out);
        name = findViewById(R.id.tv_Name);
        profileImg = findViewById(R.id.profile_img);
        userName = findViewById(R.id.tv_user_name);
        gmail = findViewById(R.id.tv_gmail);
        phone = findViewById(R.id.tv_phone);
        address = findViewById(R.id.tv_address);
        pinCode = findViewById(R.id.tv_pin_code);
        dob = findViewById(R.id.tv_dob);
        email = findViewById(R.id.tv_Email);

        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        String data = HFMPrefs.getString(getApplicationContext(), Constants.LOGIN_DATA);
        loginResponse = new Gson().fromJson(data, LoginResponse.class);


        if (loginResponse.getFirstName() != null && loginResponse.getLastName() != null) {
            name.setText("" + loginResponse.getFirstName() + " " + loginResponse.getLastName());
        }
        if (loginResponse.getUserName() != null) {
            userName.setText("" + loginResponse.getUserName());
        }
        if (loginResponse.getEmail() != null) {
            gmail.setText("" + loginResponse.getEmail());
            email.setText("" + loginResponse.getEmail());
        }
        if (loginResponse.getAddress() != null) {
            address.setText("" + loginResponse.getAddress());
        }
        if (loginResponse.getDateOfBirth() != null) {
            dob.setText("" + loginResponse.getDateOfBirth());
        }
        if (loginResponse.getPincode() != null) {
            pinCode.setText("" + loginResponse.getPincode());
        }
        if (loginResponse.getImage() != null) {
            Picasso.with(this).load(loginResponse.getImage()).error(R.drawable.header_profile).into(profileImg);

        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                userlogout();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.edit, menu);
        return true;
    }


    private void userlogout() {

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        // ...Irrelevant code for customizing the buttons and titl
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.profile_alertdialog, null);
        dialogBuilder.setView(dialogView);

        final AlertDialog dialog = dialogBuilder.create();
        Button btn_Cancel = dialogView.findViewById(R.id.btn_cancel);
        TextView text_logout = dialogView.findViewById(R.id.text_logout);
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });

        text_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HFMPrefs.putBoolean(ProfileActivity.this, Constants.LOGIN_CHECK, false);
                startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                finish();
            }
        });

        dialog.show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        if (item.getItemId() == R.id.edit_user) {
            Intent intent = new Intent(ProfileActivity.this, UpdateActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);


    }


}
