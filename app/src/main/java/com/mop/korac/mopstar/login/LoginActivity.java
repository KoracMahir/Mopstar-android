
package com.mop.korac.mopstar.login;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.interfacee.ApiInterface;
import com.mop.korac.mopstar.main.MainActivity;
import com.mop.korac.mopstar.models.TokenModel;
import com.mop.korac.mopstar.models.UserModel;
import com.mop.korac.mopstar.register.RegisterActivity;
import com.mop.korac.mopstar.service.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    Button button;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progress);

        button = findViewById(R.id.button);
        reg = findViewById(R.id.reg);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateToHome();
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent barIntent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(barIntent);
            }
        });

        presenter = new LoginPresenter(this, new LoginInteractor());
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError(getString(R.string.empty_error));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.empty_error));
    }


    @Override
    public void navigateToHome() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        ApiInterface apiInterface = ApiClient.GetApiClient().create(ApiInterface.class);
        apiInterface.loginWithCredentials(new UserModel(username.getText().toString(), password.getText().toString())).enqueue(new Callback<TokenModel>() {
            @Override
            public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
                if(response.isSuccessful()){
                    String token = response.body().getTokenString();
                    Intent barIntent = new Intent(getApplicationContext(), MainActivity.class);
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("token", token);
                    editor.commit();
                    startActivity(barIntent);
                }else{
                    Toast.makeText(LoginActivity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TokenModel> call, Throwable t) {

            }
        });
    }
    @Override
    public void SignUp() {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    private void validateCredentials() {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
