package com.mop.korac.mopstar.main;

import java.util.List;

class MainPresenter {

    private MainView mainView;

    MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    void onResume() {
        if (mainView != null) {
        }

    }

    void onItemClicked(String item) {
        if (mainView != null) {
            mainView.showMessage(String.format("%s clicked", item));
        }
    }

    void onDestroy() {
        mainView = null;
    }

    public void onFinished(List<String> items) {
        if (mainView != null) {
        }
    }

    public MainView getMainView() {
        return mainView;
    }
}