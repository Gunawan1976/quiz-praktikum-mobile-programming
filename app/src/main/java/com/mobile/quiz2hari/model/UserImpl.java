package com.mobile.quiz2hari.model;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Patterns;

public class UserImpl implements User{
    SharedPreferences sharedPreferences;

    String name, pass;
    public UserImpl(String phone,String pass){
        this.name = phone;
        this.pass = pass;
    }
    @Override
    public String getPhone() {
        return name;
    }

    @Override
    public String getPass() {
        return pass;
    }


    @Override
    public int validate() {
        if (TextUtils.isEmpty(getPhone())){
            return 0;
        }else if (!Patterns.PHONE.matcher(getPhone()).matches()){
            return 1;
        }else if (getPass().length() <= 3){
            return 2;
        }else {
            return 0;
        }
    }
}
