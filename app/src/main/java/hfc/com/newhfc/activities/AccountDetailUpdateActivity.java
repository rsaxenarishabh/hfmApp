package hfc.com.newhfc.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import hfc.com.newhfc.R;

public class AccountDetailUpdateActivity extends AppCompatActivity {
    private EditText aadharNumber,panNumber,acconutNumber,ifscCode,accontHolderName,branchName,nomineeName;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail_update);

        aadharNumber=findViewById(R.id.edittext_adhar_num);
        panNumber=findViewById(R.id.edittext_pan_num);
        aadharNumber=findViewById(R.id.edittext_adhar_num);
        ifscCode=findViewById(R.id.edittext_ifsc_code);
        accontHolderName=findViewById(R.id.edittext_actholder_name);
        branchName=findViewById(R.id.edittext_branch_name);
        nomineeName=findViewById(R.id.edittext_nominee_name);




    }
}
