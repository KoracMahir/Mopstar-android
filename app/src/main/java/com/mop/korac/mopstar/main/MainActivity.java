package com.mop.korac.mopstar.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.fragments.Event_Fragment;
import com.mop.korac.mopstar.fragments.Group_Fragment;
import com.mop.korac.mopstar.fragments.Home_Fragment;
import com.mop.korac.mopstar.fragments.Profile_Fragment;
import com.mop.korac.mopstar.interfacee.ApiInterface;
import com.mop.korac.mopstar.models.Post;
import com.mop.korac.mopstar.models.PostModel;
import com.mop.korac.mopstar.models.ProfileModel;
import com.mop.korac.mopstar.service.ApiClient;

import java.util.List;
import com.mop.korac.mopstar.Home.FeedData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity implements MainView {

    String img1="http://shashgrewal.com/wp-content/uploads/2015/05/default-placeholder-300x300.png";
    String img2="http://shashgrewal.com/wp-content/uploads/2015/05/default-placeholder-300x300.png";
    String img3="http://shashgrewal.com/wp-content/uploads/2015/05/default-placeholder-300x300.png";

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        BottomNavigationView bottomNav = findViewById(R.id.navigationbar);
        BottomNavigationViewHelper.disableShiftMode(bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Home_Fragment()).commit();
            treepics();
            getuserposts();
        }




    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.home:
                            selectedFragment = new Home_Fragment();
                            treepics();
                            getuserposts();
                            break;
                        case R.id.event:
                            selectedFragment = new Event_Fragment();
                            break;
                        case R.id.group:
                            selectedFragment = new Group_Fragment();
                            break;
                        case R.id.profile:
                            selectedFragment = new Profile_Fragment();
                            treepics();
                            getuserposts();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void treepics() {
        SharedPreferences pref = MainActivity.this.getSharedPreferences("MyPref", MODE_PRIVATE);
        String token = pref.getString("token", null);
        String id = pref.getString("id", null);
        ApiInterface apiInterface = ApiClient.GetApiClient().create(ApiInterface.class);
        apiInterface.gettreepics("Bearer "+token,id).enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                String[] threepics = new String[]{img1,img2,img3};
                for(int i=0; i<response.body().getPhotos().size(); i++){
                    String imgurl = response.body().getPhotos().get(i).getUrl();

                    threepics[i]=imgurl;

                }


                SharedPreferences.Editor editor = pref.edit();
                editor.putString("img1", threepics[0]);
                editor.putString("img2", threepics[1]);
                editor.putString("img3", threepics[2]);
                editor.commit();

            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getuserposts() {


        SharedPreferences pref = MainActivity.this.getSharedPreferences("MyPref", MODE_PRIVATE);
        String token = pref.getString("token", null);
        String profileurl = pref.getString("imgurl", null);
        String name = pref.getString("username", null);
        String id = pref.getString("id", null);
        ApiInterface apiInterface = ApiClient.GetApiClient().create(ApiInterface.class);
        apiInterface.getprofileposts("Bearer "+token,id).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                int size=response.body().size();
                String[] test = new String[size];
                String[] test2 = new String[size];
                String[] test3 = new String[size];
                for (int i=0;i<size;i++) {

                    test[i] = response.body().get(i).getContent();
                    test2[i] = name;
                    test3[i] = profileurl;
                }
                FeedData.postscontent = test;
                FeedData.imagespath = test3;
                FeedData.names = test2;


            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t, Toast.LENGTH_SHORT).show();
            }
        });
    }

}