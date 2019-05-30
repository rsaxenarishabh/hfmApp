package hfc.com.newhfc.activities;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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





    }
}
