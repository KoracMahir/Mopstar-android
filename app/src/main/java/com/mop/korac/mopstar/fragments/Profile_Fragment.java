package com.mop.korac.mopstar.fragments;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.auth0.android.jwt.JWT;
import com.google.gson.JsonObject;
import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.adapter.HomeAdapter;
import com.mop.korac.mopstar.decode.JWTUtils;
import com.mop.korac.mopstar.fragments.profile.Description_Fragment;
import com.mop.korac.mopstar.fragments.profile.Posts_Fragment;
import com.mop.korac.mopstar.interfacee.ApiInterface;
import com.mop.korac.mopstar.login.LoginActivity;
import com.mop.korac.mopstar.main.MainActivity;
import com.mop.korac.mopstar.models.TokenModel;
import com.mop.korac.mopstar.models.UploadPost;
import com.mop.korac.mopstar.models.UserModel;
import com.mop.korac.mopstar.models.PostModel;
import com.mop.korac.mopstar.service.ApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class Profile_Fragment extends Fragment{

    EditText posttext;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        button = view.findViewById(R.id.postc);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences pref = getActivity().getSharedPreferences("MyPref", MODE_PRIVATE);
                String token = pref.getString("token", null);

                posttext = view.findViewById(R.id.upload);
                ApiInterface apiInterface = ApiClient.GetApiClient().create(ApiInterface.class);
                apiInterface.uploadpost(new UploadPost(posttext.getText().toString()),"Bearer "+token).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(getActivity(), "Posted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });
        return view;
    }

}
