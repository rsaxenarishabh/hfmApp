package hfc.com.newhfc.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;

import hfc.com.newhfc.R;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFCPrefs;

public class SplashActivity extends BaseActivity {
    private static final String TAG = "SplashActivity";
    private String payload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT > 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.black));
        }


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {

                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 5000);
    }
       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (HFCPrefs.getBoolean(SplashActivity.this, Constants.USER_LOGGED_IN)){
                    Intent launchingIntent = new Intent(SplashActivity.this, MainActivity.class);
                    launchingIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    launchingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(launchingIntent);
                    overridePendingTransition(0, 0);
                    finish();
                }else{
                    Intent launchingIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    launchingIntent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    launchingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(launchingIntent);
                    overridePendingTransition(0, 0);
                    finish();
                }


            }
        },3000);
*/
    }


