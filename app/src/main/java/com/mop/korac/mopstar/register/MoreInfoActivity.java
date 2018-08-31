package com.mop.korac.mopstar.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.interfacee.ApiInterface;
import com.mop.korac.mopstar.login.LoginActivity;
import com.mop.korac.mopstar.main.MainActivity;
import com.mop.korac.mopstar.models.TokenModel;
import com.mop.korac.mopstar.models.UserModel;
import com.mop.korac.mopstar.service.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoreInfoActivity extends AppCompatActivity {

    Button skip;
    Button cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        skip = findViewById(R.id.skip);
        cont = findViewById(R.id.register);
        autologin();
        skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Skip();
            }
        });
        cont.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Cont();
            }
        });
    }

    public void Skip() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    public void Cont() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    public void autologin() {
        SharedPreferences pref = MoreInfoActivity.this.getSharedPreferences("MyPref", MODE_PRIVATE);
        String username = pref.getString("loginuser", null);
        String password = pref.getString("loginpass", null);
        ApiInterface apiInterface = ApiClient.GetApiClient().create(ApiInterface.class);
        apiInterface.loginWithCredentials(new UserModel(username, password)).enqueue(new Callback<TokenModel>() {
            @Override
            public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
                if(response.isSuccessful()){
                    String token = response.body().getTokenString();
                    String id = response.body().getProfileModel().getId();
                    String username = response.body().getProfileModel().getUsername();
                    String imgurl = response.body().getProfileModel().getPhotourl();
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("token", token);
                    editor.putString("id", id);
                    editor.putString("username", username);
                    editor.putString("imgurl", imgurl);
                    editor.commit();
                }else{
                    Toast.makeText(MoreInfoActivity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TokenModel> call, Throwable t) {
                Toast.makeText(MoreInfoActivity.this, ""+t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
