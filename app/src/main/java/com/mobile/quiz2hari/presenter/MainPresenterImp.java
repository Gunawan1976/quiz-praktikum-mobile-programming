package com.mobile.quiz2hari.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.mobile.quiz2hari.MainActivity;
import com.mobile.quiz2hari.model.User;
import com.mobile.quiz2hari.model.UserImpl;
import com.mobile.quiz2hari.view.MainView;

public class MainPresenterImp implements MainPresenter {

    MainView mainView;

    public MainPresenterImp(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onLogin(String name, String password) {
        UserImpl user = new UserImpl(name,password);
        int logincode = user.validate();

        if (logincode == 0){
            mainView.LooginError("masukan yang benar");
        }else if (logincode == 1) {
            mainView.LoginSucces("login Succes");
        } else{
            mainView.LooginError("error goblok");
        }

    }
}
