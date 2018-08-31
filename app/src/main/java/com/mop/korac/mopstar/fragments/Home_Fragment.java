package com.mop.korac.mopstar.fragments;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.interfacee.ApiInterface;
import com.mop.korac.mopstar.models.UploadPost;
import com.mop.korac.mopstar.service.ApiClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class Home_Fragment extends Fragment {

    EditText posttext;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
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
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleview);
//
//        HomeAdapter homeAdapter = new HomeAdapter();
//        recyclerView.setAdapter(homeAdapter);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
        return view;
    }




}
