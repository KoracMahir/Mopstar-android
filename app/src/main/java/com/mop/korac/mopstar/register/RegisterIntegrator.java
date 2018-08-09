package com.mop.korac.mopstar.register;

import android.os.Handler;
import android.text.TextUtils;

public class RegisterIntegrator {

    interface OnRegisterFinishedListener {
        void NameError1();

        void onUsernameError1();

        void onPasswordError1();

        void onSuccess1();
    }

    public void register(final String name,final String username, final String password, final RegisterPresenter listener) {
        new Handler().postDelayed(() -> {
            if (TextUtils.isEmpty(name)) {
                listener.NameError1();
                return;
            }
            if (TextUtils.isEmpty(username)) {
                listener.onUsernameError1();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                listener.onPasswordError1();
                return;
            }
            listener.onSuccess1();
        }, 2000);
    }
}
