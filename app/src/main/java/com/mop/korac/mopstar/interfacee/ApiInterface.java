package com.mop.korac.mopstar.interfacee;

import com.mop.korac.mopstar.models.PostModel;
import com.mop.korac.mopstar.models.TokenModel;
import com.mop.korac.mopstar.models.UserModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @POST("api/auth/login")
    Call<TokenModel> loginWithCredentials(@Body UserModel userModel);

    @POST("api/auth/register")
    Call<ResponseBody> registerWithCredentials(@Body UserModel userModel);

    @Headers("eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiIxIiwidW5pcXVlX25hbWUiOiJkaW5vc21ham92aWMiLCJhY3RvcnQiOiJodHRwOi8vc2ctZnMuY29tL3dwLWNvbnRlbnQvdXBsb2Fkcy8yMDE3LzA4L3VzZXItcGxhY2Vob2xkZXIucG5nIiwibmJmIjoxNTM1MTMwNTMyLCJleHAiOjE1MzUyMTY5MzIsImlhdCI6MTUzNTEzMDUzMn0.StvoPxDIlPBc_EuTLyH-NLcJeIsl-bpHkVNSzLx3T2c76QnZUDujB-FpFNNBb-Ebh9VYa-WwWF1GJgMHapd8Yg")
    @GET("api/users/{numm}/posts")
    Call<List<PostModel>> getUsersPosts(@Path("numm") int numm);




//    @GET("nesto/{xyv}/status")
//    Call<Object> getPosts(@Path("xyv") int broj);

}

