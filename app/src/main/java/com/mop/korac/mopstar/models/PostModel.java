package com.mop.korac.mopstar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostModel {
    @SerializedName("content")
    @Expose
    private String Content;

    @SerializedName("likesNum")
    @Expose
    private int likes;

    @SerializedName("userId")
    @Expose
    private String  userid;


    public String getContent() {
        return Content;
    }



    public int getLikes() {
        return likes;
    }

    public String getUserid() {
        return userid;
    }



    public void setContent(String content) {
        Content = content;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }


    @Override
    public String toString() {
        return "PostModel{" +
                "Content='" + Content + '\'' +
                ", likes=" + likes +
                ", userid=" + userid +
                '}';
    }
}
