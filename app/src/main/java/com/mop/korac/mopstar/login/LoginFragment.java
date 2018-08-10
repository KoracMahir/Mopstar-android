package com.mop.korac.mopstar.login;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.main.MainActivity;
import com.mop.korac.mopstar.register.RegisterActivity;

public class LoginFragment extends Fragment implements LoginView{

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenter(this, new LoginInteractor());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_login, container, false);
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
        startActivity(new Intent(LoginFragment.this, MainActivity.class));
    }

    @Override
    public void SignUp() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    private void validateCredentials() {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
