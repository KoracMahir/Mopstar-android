package com.mop.korac.mopstar.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.interfacee.ApiInterface;
import com.mop.korac.mopstar.login.LoginActivity;
import com.mop.korac.mopstar.login.LoginInteractor;
import com.mop.korac.mopstar.login.LoginPresenter;
import com.mop.korac.mopstar.login.LoginView;
import com.mop.korac.mopstar.main.MainActivity;
import com.mop.korac.mopstar.models.TokenModel;
import com.mop.korac.mopstar.models.UserModel;
import com.mop.korac.mopstar.service.ApiClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private RegisterPresenter presenter;

    Button button;
    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar = findViewById(R.id.progress);

        button = findViewById(R.id.button);
        log = findViewById(R.id.log);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                navigateToHome();
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent barIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(barIntent);
            }
        });

        presenter = new RegisterPresenter(this, new RegisterInteractor());
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
        username = findViewById(R.id.name);
        password = findViewById(R.id.pass);
        ApiInterface apiInterface = ApiClient.GetApiClient().create(ApiInterface.class);
        apiInterface.registerWithCredentials(new UserModel(username.getText().toString(), password.getText().toString())).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Intent barIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(barIntent);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
    @Override
    public void Login() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void validateCredentials() {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
