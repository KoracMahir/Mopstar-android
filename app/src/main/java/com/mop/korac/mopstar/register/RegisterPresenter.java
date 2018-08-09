package com.mop.korac.mopstar.register;

public class RegisterPresenter implements RegisterIntegrator.OnRegisterFinishedListener {

    private RegisterView registerView;
    private RegisterIntegrator registerIntegrator;

    RegisterPresenter(RegisterView registerView, RegisterIntegrator registerInteractor) {
        this.registerView = registerView;
        this.registerIntegrator = registerInteractor;
    }

    public void validateCredentials(String name,String username, String password) {
            registerView.showProgress();

        registerIntegrator.register(name, username, password, this);
    }

    public void onDestroy() {
        registerView = null;
    }
    @Override
    public void NameError1() {
        registerView.NameError();
        registerView.hideProgress();
    }

    @Override
    public void onUsernameError1() {
        registerView.setUsernameError();
        registerView.hideProgress();
    }

    @Override
    public void onPasswordError1() {
        registerView.setPasswordError();
        registerView.hideProgress();
    }

    @Override
    public void onSuccess1() {
        registerView.navigateToHome();
    }
}
