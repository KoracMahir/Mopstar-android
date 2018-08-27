package com.mop.korac.mopstar.register;

public interface RegisterView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void Login();
}
