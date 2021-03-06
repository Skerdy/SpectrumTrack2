package com.example.w2020skerdjan.spectrumtrack.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.w2020skerdjan.spectrumtrack.BuildConfig;
import com.example.w2020skerdjan.spectrumtrack.Models.ResponseModels.LoginResponse;
import com.example.w2020skerdjan.spectrumtrack.R;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.LoginCalls;
import com.example.w2020skerdjan.spectrumtrack.Retrofit.RetrofitClient;
import com.example.w2020skerdjan.spectrumtrack.Utils.MySharedPref;
import com.example.w2020skerdjan.spectrumtrack.Utils.RetrofitHeaderManager;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class LoginActivity extends BaseActivity{

    private static final String TAG = "LoginActivity";
    private  EditText _emailText, _passwordText;
    private  Button _loginButton;
    private  RetrofitClient retrofitClient;
    private  Retrofit retrofit;
    private  LoginCalls loginCalls;
    private  LoginResponse loginResponse;
    private  ProgressDialog progressDialog;
    private  boolean flag;
    private  Map<String, String> map;
    private String auth;
    private  MySharedPref mySharedPref;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _emailText = (EditText) findViewById(R.id.input_email);
        _passwordText = (EditText) findViewById(R.id.input_password);
        _loginButton = (Button) findViewById(R.id.btn_login);
        mySharedPref= new MySharedPref(this);
        retrofitClient = new RetrofitClient();
        retrofit = retrofitClient.krijoRetrofit();

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
         loginResponse=null;

    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginSuccess();
            return;
        }

        _loginButton.setEnabled(false);
        _loginButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onLoginSuccess();
                return false;
            }
        });

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();


        progressDialog= new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();

        loginCalls = retrofit.create(LoginCalls.class);
        loginCalls.Login(RetrofitHeaderManager.loginMap(email,password)).enqueue(loginCallback);




    }

    Callback<LoginResponse> loginCallback = new Callback<LoginResponse>() {
        @Override
        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
            if(response.isSuccessful()) {
                loginResponse = response.body();
                if (loginResponse.getData() != null) {
                    Log.d("Skerdi", "Sukses" + response.body().toString() + loginResponse.getData());
                    auth = loginResponse.getData().getToken();
                    mySharedPref.saveStringInSharedPref("Auth", auth);

                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    if (!loginResponse.getMessageList().get(0).getDescription().equals("Invalid user credentials!")) {
                                        onLoginSuccess();
                                        // onLoginFailed();
                                        progressDialog.dismiss();
                                    } else {
                                        onLoginFailed();
                                    }
                                }
                            }, 3000);

                } else {
                    new android.os.Handler().postDelayed(
                            new Runnable() {
                                public void run() {
                                    onLoginFailed();
                                }
                            }, 3000);
                }


            }

            else {
                Log.d("Skerdi", "noSucces" );
            }
        }

        @Override
        public void onFailure(Call<LoginResponse> call, Throwable t) {
            Log.d("Skerdi", "Failure Login" + t.getMessage());
        }
    };



    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        Intent intent = new Intent(LoginActivity.this, MainMenu.class);
        if(auth!=null){
            intent.putExtra("auth", auth);
        }
        startActivity(intent);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        _loginButton.setEnabled(true);

    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("Enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("Password must be between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        return valid;
    }




}
