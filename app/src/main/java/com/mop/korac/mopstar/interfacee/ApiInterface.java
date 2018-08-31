package com.mop.korac.mopstar.interfacee;

import android.content.SharedPreferences;

import com.mop.korac.mopstar.models.PhotoModel;
import com.mop.korac.mopstar.models.Post;
import com.mop.korac.mopstar.models.PostModel;
import com.mop.korac.mopstar.models.ProfileModel;
import com.mop.korac.mopstar.models.TokenModel;
import com.mop.korac.mopstar.models.UploadPost;
import com.mop.korac.mopstar.models.UserModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static android.content.Context.MODE_PRIVATE;

public interface ApiInterface {

//    String auth = "Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiIxOCIsInVuaXF1ZV9uYW1lIjoibWFoaXIiLCJuYmYiOjE1MzU1NjU3MjAsImV4cCI6MTUzNTY1MjEyMCwiaWF0IjoxNTM1NTY1NzIwfQ.9K-rqFCAv6zVy_v6JrA0IQvzlrvnXTDNPmNc4oI9S5g96TXKG529iwd_GIhfX_BSWGnyM4wsMiiFU-CPgnuW6g";

    @POST("api/auth/login")
    Call<TokenModel> loginWithCredentials(@Body UserModel userModel);

    @POST("api/auth/register")
    Call<ResponseBody> registerWithCredentials(@Body UserModel userModel);

//    @Headers({"Authorization : Bearer eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiIxOCIsInVuaXF1ZV9uYW1lIjoibWFoaXIiLCJuYmYiOjE1MzU1NjU3MjAsImV4cCI6MTUzNTY1MjEyMCwiaWF0IjoxNTM1NTY1NzIwfQ.9K-rqFCAv6zVy_v6JrA0IQvzlrvnXTDNPmNc4oI9S5g96TXKG529iwd_GIhfX_BSWGnyM4wsMiiFU-CPgnuW6g"})
    @GET("api/users/{id}")
    Call<ProfileModel> gettreepics(
            @Header("Authorization") String auth,
            @Path("id") String id
    );

    @GET("api/users/{id}/posts")
    Call<List<PostModel>> getprofileposts(
            @Header("Authorization") String auth,
            @Path("id") String id
    );

    @POST("api/users/posts")
    Call<ResponseBody> uploadpost(
            @Body UploadPost uploadPost,
            @Header("Authorization") String auth);

    @GET("api/users/feed")
    Call<List<PostModel>> getfeed(
            @Header("Authorization") String auth
    );

//    @GET("nesto/{xyv}/status")
//    Call<Object> getPosts(@Path("xyv") int broj);

}

