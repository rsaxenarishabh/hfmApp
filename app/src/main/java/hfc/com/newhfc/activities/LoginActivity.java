package hfc.com.newhfc.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.internal.Utils;
import hfc.com.newhfc.R;
import hfc.com.newhfc.model.LoginRequestModel;
import hfc.com.newhfc.model.LoginResponse;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.AppUtils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFCPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        mLoginFormView = findViewById(R.id.login_form);
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            LoginRequestModel loginRequestModel = new LoginRequestModel();
            loginRequestModel.setEmailAddress(email);
            loginRequestModel.setPassword(password);
            AppUtils.showProgressDialog(this);
            RestClient.login(loginRequestModel, new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        LoginResponse responseModel = response.body();
                        AppUtils.dismissProgressDialog();
                        if (response.code() == 200) {
                            Toast.makeText(LoginActivity.this, "Logged in succesfully", Toast.LENGTH_LONG).show();
                            HFCPrefs.putBoolean(LoginActivity.this, Constants.USER_LOGGED_IN, true);
                            HFCPrefs.putString(LoginActivity.this, Constants.ACCESS_TOKEN, responseModel.getAccessToken());
                            HFCPrefs.putString(LoginActivity.this, Constants.USER_NAME, responseModel.getUser().getFirstName());
                            HFCPrefs.putInt(LoginActivity.this, Constants.LOGGED_IN_USER_ID, responseModel.getUser().getId().intValue());
                            HFCPrefs.putString(LoginActivity.this, Constants.REFERRAL_CODE, responseModel.getUser().getReferalCode());
                            HFCPrefs.putString(LoginActivity.this, Constants.LOGIN_DATA, new Gson().toJson(responseModel));
                            Intent intent = null;
                            if (responseModel.getUser().getIsActive()) {
                                intent = new Intent(LoginActivity.this, MainActivity.class);
                            } else {
                                intent = new Intent(LoginActivity.this, AccountNotActivatedActivity.class);
                            }
                            LoginActivity.this.startActivity(intent);
                            LoginActivity.this.finish();
                            return;
                        }

                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    AppUtils.dismissProgressDialog();
                Log.d(LoginActivity.class.getSimpleName(),"Login failed");
                }
            });
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


}

