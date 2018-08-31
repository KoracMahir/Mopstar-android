package com.mop.korac.mopstar.fragments.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.decode.JWTUtils;
import com.mop.korac.mopstar.interfacee.ApiInterface;
import com.mop.korac.mopstar.login.LoginActivity;
import com.mop.korac.mopstar.main.MainActivity;
import com.mop.korac.mopstar.models.PhotoModel;
import com.mop.korac.mopstar.models.ProfileModel;
import com.mop.korac.mopstar.models.TokenModel;
import com.mop.korac.mopstar.models.UserModel;
import com.mop.korac.mopstar.register.RegisterActivity;
import com.mop.korac.mopstar.service.ApiClient;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class Description_Fragment extends Fragment {
    ImageView profileimg;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.description, container, false);
        SharedPreferences pref = getActivity().getSharedPreferences("MyPref", MODE_PRIVATE);
        try {
            profileimg = (ImageView) view.findViewById(R.id.profileimg);
            TextView profilename = (TextView) view.findViewById(R.id.profilename);
            TextView profilesubname = (TextView) view.findViewById(R.id.profilesubname);
            img1 = (ImageView) view.findViewById(R.id.photo1);
            img2 = (ImageView) view.findViewById(R.id.photo2);
            img3 = (ImageView) view.findViewById(R.id.photo3);

            String image1 = pref.getString("img1", null);
            String image2 = pref.getString("img2", null);
            String image3 = pref.getString("img3", null);


            String profileurl = pref.getString("imgurl", null);
            String name = pref.getString("username", null);
            String subname = "@"+name;

            profilename.setText(name);
            profilesubname.setText(subname);
            loadImageFromUrl(profileurl);

            pic1(image1);
            pic2(image2);
            pic3(image3);

        } catch (Exception e) {
            e.printStackTrace();
        }

        button = view.findViewById(R.id.logout);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent barIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(barIntent);
            }
        });
        return view;
    }

    private void loadImageFromUrl(String profileurl) {
        Picasso.with(getActivity()).load(profileurl).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(profileimg,new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
    private void pic1(String image1) {
        Picasso.with(getActivity()).load(image1).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(img1,new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
    private void pic2(String image2) {
        Picasso.with(getActivity()).load(image2).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(img2,new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
    private void pic3(String image3) {
        Picasso.with(getActivity()).load(image3).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(img3,new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }

}
