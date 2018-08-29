package com.mop.korac.mopstar.fragments.profile;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.decode.JWTUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

public class Description_Fragment extends Fragment {
    ImageView profileimg;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.description, container, false);
        SharedPreferences pref = getActivity().getSharedPreferences("MyPref", MODE_PRIVATE);
        String token=pref.getString("token", null);
        try {
            String decoded = JWTUtils.body(token);
            JSONObject obj = new JSONObject(decoded);

            profileimg = (ImageView) view.findViewById(R.id.profileimg);
            TextView profilename = (TextView) view.findViewById(R.id.profilename);
            TextView profilesubname = (TextView) view.findViewById(R.id.profilesubname);

            String profileurl = obj.getString("actort");
            String name = obj.getString("unique_name");
            String subname = "@"+obj.getString("unique_name");

            profilename.setText(name);
            profilesubname.setText(subname);
            loadImageFromUrl(profileurl);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
