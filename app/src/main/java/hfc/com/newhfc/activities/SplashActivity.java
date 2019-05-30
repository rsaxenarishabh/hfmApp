package hfc.com.newhfc.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;

import hfc.com.newhfc.R;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFMPrefs;

public class SplashActivity extends BaseActivity {
    private static final String TAG = "SplashActivity";
    private String payload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (Build.VERSION.SDK_INT > 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (HFMPrefs.getBoolean(SplashActivity.this, Constants.LOGIN_CHECK)) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, 3000);

    }
}


