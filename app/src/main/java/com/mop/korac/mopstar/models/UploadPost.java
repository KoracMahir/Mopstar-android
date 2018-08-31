package com.mop.korac.mopstar.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadPost {

    @SerializedName("Content")
    @Expose
    public String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public UploadPost(String content) {
        Content = content;
    }
}
