package com.mop.korac.mopstar.register;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mop.korac.mopstar.BaseActivity;
import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.login.LoginActivity;
import com.mop.korac.mopstar.main.MainActivity;

public class RegisterActivity extends BaseActivity implements RegisterView {
    Button button;
    private ProgressBar progressBar;
    private EditText name;
    private EditText username;
    private EditText password;
    private RegisterPresenter presenter;

    @Override
    public void onAttach(){
        super.onAttach();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar = findViewById(R.id.progress);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(v -> validateCredentials());

        presenter = new RegisterPresenter(this, new RegisterIntegrator());

        button = findViewById(R.id.log);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Login();
            }
        });
        button = findViewById(R.id.close);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Login();
            }
        });
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
    public void NameError() {
        name.setError(getString(R.string.empty_error));
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
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    @Override
    public void Login() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
    @Override
    public void Close() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void validateCredentials() {
        presenter.validateCredentials(name.getText().toString(),username.getText().toString(), password.getText().toString());
    }
}
