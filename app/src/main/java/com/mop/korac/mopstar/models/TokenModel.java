package com.mop.korac.mopstar.models;

import com.google.gson.annotations.SerializedName;

public class TokenModel {
    public String getTokenString() {
        return tokenString;
    }

    @SerializedName("tokenString")
    String tokenString;
}

