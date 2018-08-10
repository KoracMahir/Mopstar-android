
package com.mop.korac.mopstar.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mop.korac.mopstar.BaseActivity;
import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.main.MainActivity;
import com.mop.korac.mopstar.register.RegisterActivity;

public class LoginActivity extends BaseActivity{

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progress);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(v -> validateCredentials());
        final Button button = findViewById(R.id.reg);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SignUp();
            }
        });
    }

    @Override
    public void onDestroy() {
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
        startActivity(new Intent(this, MainActivity.class));
        finish();
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
