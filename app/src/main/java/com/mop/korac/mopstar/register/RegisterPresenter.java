package com.mop.korac.mopstar.register;

import com.mop.korac.mopstar.register.RegisterInteractor;
import com.mop.korac.mopstar.register.RegisterView;

public class RegisterPresenter implements RegisterInteractor.OnRegisterFinishedListener {

    private RegisterView registerView;
    private RegisterInteractor registerInteractor;

    RegisterPresenter(RegisterView registerView, RegisterInteractor registerInteractor) {
        this.registerView = registerView;
        this.registerInteractor = registerInteractor;
    }

    public void validateCredentials(String username, String password) {
        if (registerView != null) {
            registerView.showProgress();
        }

        registerInteractor.login(username, password, this);
    }

    public void onDestroy() {
        registerView = null;
    }

    @Override
    public void onUsernameError() {
        registerView.setUsernameError();
        registerView.hideProgress();
    }

    @Override
    public void onPasswordError() {
        registerView.setPasswordError();
        registerView.hideProgress();
    }

    @Override
    public void onSuccess() {
        registerView.navigateToHome();
    }
}
