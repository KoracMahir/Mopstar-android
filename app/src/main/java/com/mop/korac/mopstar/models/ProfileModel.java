package com.mop.korac.mopstar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfileModel {

    @SerializedName("username")
    @Expose
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    @SerializedName("photoUrl")
    @Expose
    private String photourl;

    @SerializedName("photos")
    @Expose
    private List<PhotoModel> photos = null;


    public List<PhotoModel> getPhotos() {
        return photos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("id")
    @Expose
    private String id;

    @Override
    public String toString() {
        return "ProfileModel{" +
                "username='" + username + '\'' +
                ", photourl='" + photourl + '\'' +
                ", photos=" + photos +
                ", id='" + id + '\'' +
                '}';
    }
}
