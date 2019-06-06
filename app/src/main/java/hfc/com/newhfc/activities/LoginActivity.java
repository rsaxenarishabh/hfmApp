package hfc.com.newhfc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import hfc.com.newhfc.R;
import hfc.com.newhfc.model.login.LoginRequest;
import hfc.com.newhfc.model.login.LoginResponse;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.Utils;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFMPrefs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;


    private  TextView textViewPrivacy;

    // UI references.
    private AutoCompleteTextView mUsername;
    private EditText mPasswordView;
    private CheckBox checkBox;
    private Boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        // Set up the login form.

        textViewPrivacy=findViewById(R.id.privacy_policy);
        mUsername = (AutoCompleteTextView) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);
        checkBox = findViewById(R.id.login_checkbox);
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




        SpannableString spannableString = new SpannableString(getString(R.string.terms));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textViewPrivacy.setText(spannableString);
        textViewPrivacy.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,WebViewActivity.class);
                intent.putExtra("title","Privacy Policy");
                startActivity(intent);
            }
        });


        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        // Reset errors.
        mUsername.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String username = mUsername.getText().toString();
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
        if (TextUtils.isEmpty(username)) {
            mUsername.setError(getString(R.string.error_field_required));
            focusView = mUsername;
            cancel = true;
        }

        if (checkBox.isChecked()) {
            check = true;
            HFMPrefs.putBoolean(this, Constants.LOGIN_CHECK, check);
        } else {
            check = false;
            HFMPrefs.putBoolean(this, Constants.LOGIN_CHECK, check);
        }


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
             if(check)
             {
                 final LoginRequest loginRequest = new LoginRequest();
                 loginRequest.setUserName(username);
                 loginRequest.setPassword(password);
                 Utils.showProgressDialog(this);
                 if (Utils.isInternetConnected(this)) {
                     Utils.showProgressDialog(this);
                     RestClient.loginUser(loginRequest, new Callback<LoginResponse>() {
                         @Override
                         public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                             Utils.dismissProgressDialog();
                             if (response.body() != null) {
                                 LoginResponse loginResponse = response.body();
                                 if (response.code() == 200) {
                                     HFMPrefs.putString(LoginActivity.this, Constants.REFERAL, loginResponse.getReferal());
                                     HFMPrefs.putString(LoginActivity.this, Constants.USER_ID, loginResponse.getId());
                                     HFMPrefs.putString(LoginActivity.this, Constants.USER_ID, loginResponse.getId());
                                     HFMPrefs.putString(LoginActivity.this, Constants.LOGIN_DATA, new Gson().toJson(loginResponse));

                                     Intent intent = null;
                                     if (loginResponse.getActiveStatus().equalsIgnoreCase("1")) {
                                         intent = new Intent(LoginActivity.this, MainActivity.class);
                                         startActivity(intent);
                                         finish();
                                     } else {
                                         Toast.makeText(LoginActivity.this, "User is Not Activate", Toast.LENGTH_SHORT).show();
                                     }

                                 }


                             }


                         }

                         @Override
                         public void onFailure(Call<LoginResponse> call, Throwable t) {
                             Utils.dismissProgressDialog();
                             Toast.makeText(LoginActivity.this, R.string.response_failed, Toast.LENGTH_SHORT).show();

                         }
                     });

                 } else {
                     Utils.dismissProgressDialog();
                     Toast.makeText(this, R.string.Internet_failed, Toast.LENGTH_SHORT).show();
                 }
             }
             else {
                 Toast.makeText(this, "Please Select the Remember Check Box", Toast.LENGTH_SHORT).show();
             }


         /*
            RestClient.login(loginRequestModel, new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        LoginResponse responseModel = response.body();

                        Utils.dismissProgressDialog();
                        if (response.code() == 200) {
                            Toast.makeText(LoginActivity.this, "Logged in succesfully", Toast.LENGTH_LONG).show();
                            //HFMPrefs.putBoolean(LoginActivity.this, Constants.USER_LOGGED_IN, true);
                            HFMPrefs.putString(LoginActivity.this, Constants.ACCESS_TOKEN, responseModel.getAccessToken());
                            HFMPrefs.putString(LoginActivity.this, Constants.USER_NAME, responseModel.getUser().getFirstName());
                            HFMPrefs.putInt(LoginActivity.this, Constants.LOGGED_IN_USER_ID, responseModel.getUser().getId().intValue());
                            HFMPrefs.putString(LoginActivity.this, Constants.REFERRAL_CODE, responseModel.getUser().getReferalCode());
                            HFMPrefs.putString(LoginActivity.this, Constants.LOGIN_DATA, new Gson().toJson(responseModel));
                            Intent intent = null;
                            if (responseModel.getUser().getIsActive()) {
                                intent = new Intent(LoginActivity.this, MainActivity.class);
                            } else {
                                intent = new Intent(LoginActivity.this, AccountNotActivatedActivity.class);
                            }
                            startActivity(intent);
                            LoginActivity.this.finish();
                            return;
                        }

                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Utils.dismissProgressDialog();
                    Log.d(LoginActivity.class.getSimpleName(), "Login failed");
                }
            });
        }*/
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

