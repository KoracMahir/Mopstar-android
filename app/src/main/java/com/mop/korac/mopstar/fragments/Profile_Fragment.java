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
import android.widget.Toast;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.fragments.profile.Description_Fragment;
import com.mop.korac.mopstar.fragments.profile.Posts_Fragment;
import com.mop.korac.mopstar.interfacee.ApiInterface;
import com.mop.korac.mopstar.login.LoginActivity;
import com.mop.korac.mopstar.main.MainActivity;
import com.mop.korac.mopstar.models.TokenModel;
import com.mop.korac.mopstar.models.UserModel;
import com.mop.korac.mopstar.models.PostModel;
import com.mop.korac.mopstar.service.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile_Fragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        Button button = (Button) view.findViewById(R.id.press);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(), "Toast TEST", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
