package com.mop.korac.mopstar.login;

public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void validateCredentials(String username, String password) {
            loginView.showProgress();

        loginInteractor.login(username, password, this);
    }

    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
            loginView.setUsernameError();
            loginView.hideProgress();
    }

    @Override
    public void onPasswordError() {
            loginView.setPasswordError();
            loginView.hideProgress();
    }

    @Override
    public void onSuccess() {
            loginView.navigateToHome();
    }

}
