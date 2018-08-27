package com.mop.korac.mopstar.main;

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

public class MainActivity extends AppCompatActivity implements MainView {



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

        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.home:
                            selectedFragment = new Home_Fragment();
                            break;
                        case R.id.event:
                            selectedFragment = new Event_Fragment();
                            break;
                        case R.id.group:
                            selectedFragment = new Group_Fragment();
                            break;
                        case R.id.profile:
                            selectedFragment = new Profile_Fragment();
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
}