package hfc.com.newhfc.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import hfc.com.newhfc.R;

public class UpdateActivity extends AppCompatActivity {
    private EditText name,lastName,phoneNumber,email,dob,address,pinCode;
    private Button submit;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name=findViewById(R.id.et_firstname);
        lastName=findViewById(R.id.et_lastname);
        phoneNumber=findViewById(R.id.et_phonenumber);
        email=findViewById(R.id.et_email);
        dob=findViewById(R.id.et_dob);
        address=findViewById(R.id.et_address);
        pinCode=findViewById(R.id.et_pincode);
        submit=findViewById(R.id.btn_submit);

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
