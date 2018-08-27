package com.mop.korac.mopstar.models;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("username")
    private String Name;

    @SerializedName("password")
    private String Password;

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;

    }

    public String getPassword() {
        return Password;
    }

    public UserModel(String name, String password) {
        Name = name;
        Password = password;
    }
}
