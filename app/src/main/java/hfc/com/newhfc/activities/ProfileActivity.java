package hfc.com.newhfc.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import hfc.com.newhfc.R;

public class ProfileActivity extends AppCompatActivity {
    private ImageView pro_img;
    private TextView name,userName,gmail,phone,address,pinCode,dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name=findViewById(R.id.tv_Name);
        userName=findViewById(R.id.tv_user_name);
        gmail=findViewById(R.id.tv_gmail);
        phone=findViewById(R.id.tv_phone);
        address=findViewById(R.id.tv_address);
        pinCode=findViewById(R.id.tv_pin_code);
        dob=findViewById(R.id.tv_dob);


    }
}
