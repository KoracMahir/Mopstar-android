package com.mop.korac.mopstar.register;

public interface RegisterView {
    void showProgress();

    void hideProgress();

    void NameError();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();

    void Login();

    void Close();
}
