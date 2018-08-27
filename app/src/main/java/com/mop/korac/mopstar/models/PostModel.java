package com.mop.korac.mopstar.models;

import com.google.gson.annotations.SerializedName;

public class PostModel {
    @SerializedName("content")
    private String Content;

    @SerializedName("likesNum")
    private int likes;

    @SerializedName("userId")
    private int userid;

    public String getContent() {
        return Content;
    }

    public int getLikes() {
        return likes;
    }

    public int getUserid() {
        return userid;
    }


}
