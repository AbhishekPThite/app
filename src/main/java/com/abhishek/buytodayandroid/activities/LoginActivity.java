package com.abhishek.buytodayandroid.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.abhishek.buytodayandroid.R;
import com.abhishek.buytodayandroid.viewModel.AccViewModel;
import com.abhishek.buytodayandroid.data.remote.APIService;
import com.abhishek.buytodayandroid.data.remote.ApiUtils;
import com.abhishek.buytodayandroid.datastore.Account;
import com.abhishek.buytodayandroid.model.LoginRequest;
import com.abhishek.buytodayandroid.model.LoginResponse;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private APIService mAPIService;
    private AccViewModel accvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       final EditText username = (EditText) findViewById(R.id.username);
       final EditText password = (EditText) findViewById(R.id.password);
       Button submitBtn = (Button) findViewById(R.id.submit);
       final ProgressBar bar = (ProgressBar) findViewById(R.id.pBar) ;


        mAPIService = ApiUtils.getAPIService();

        accvm = ViewModelProviders.of(this).get(AccViewModel.class);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass)) {
                    bar.setVisibility(View.VISIBLE);
                    login(user, pass);
                }
            }
        });

    }

    public void login(String user, String pass) {

        LoginRequest login  = new LoginRequest();
        login.setPassword(pass);
        login.setUsername(user);
        mAPIService.login(login).enqueue(new Callback<List<LoginResponse>>() {
            @Override
            public void onResponse(Call<List<LoginResponse>> call, Response<List<LoginResponse>> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<LoginResponse>> call, Throwable t) {
                Log.d("my app error", "response error");
            }
        });
    }

    public void showResponse(List<LoginResponse> response) {

       for(LoginResponse acc : response){

           try {
               Account accmodel = new Account();
               accmodel.custId = acc.getCustId();
               accmodel.accountNo = acc.getAccountNo();
               accmodel.balance = "S$" + acc.getBalance();
               accmodel.desc = acc.getDesc();
               accmodel.type = acc.getType();
               accvm.insert(accmodel);
           }catch(Exception e){

           }

        }

        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }


}
