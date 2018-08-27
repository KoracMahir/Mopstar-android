package com.mop.korac.mopstar.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.login.LoginActivity;
import com.mop.korac.mopstar.main.MainActivity;

public class MoreInfoActivity extends AppCompatActivity {

    Button skip;
    Button cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        skip = findViewById(R.id.skip);
        cont = findViewById(R.id.register);
        skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Skip();
            }
        });
        cont.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Cont();
            }
        });
    }

    public void Skip() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    public void Cont() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
