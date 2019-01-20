package hfc.com.newhfc.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hfc.com.newhfc.R;

public class AddUserActivity extends AppCompatActivity {
    public String referalCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        if (getIntent().hasExtra("referalCode")) {
            referalCode = getIntent().getStringExtra("referalCode");
        }
    }
}
