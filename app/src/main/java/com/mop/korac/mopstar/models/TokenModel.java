package com.mop.korac.mopstar.models;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenModel {

    @SerializedName("tokenString")
    @Expose
    public String tokenString;

    @SerializedName("user")
    @Expose
    public ProfileModel profileModel;

    public String getTokenString() {
        return tokenString;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }

    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "tokenString='" + tokenString + '\'' +
                ", profileModel=" + profileModel +
                '}';
    }
}

