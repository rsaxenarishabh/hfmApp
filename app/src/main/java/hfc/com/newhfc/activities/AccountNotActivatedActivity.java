package hfc.com.newhfc.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import hfc.com.newhfc.R;

public class AccountNotActivatedActivity extends AppCompatActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_account_not_activated);
        ButterKnife.bind((Activity) this);
    }
}
