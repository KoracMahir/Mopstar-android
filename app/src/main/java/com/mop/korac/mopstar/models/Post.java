package com.mop.korac.mopstar.models;

import java.util.List;

public class Post {

    public List<PostModel> postModel;

    public List<PostModel> getPostModel() {
        return postModel;
    }

    public void setPostModel(List<PostModel> postModel) {
        this.postModel = postModel;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postModel=" + postModel +
                '}';
    }
}
