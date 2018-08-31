package com.mop.korac.mopstar.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mop.korac.mopstar.R;
import com.mop.korac.mopstar.main.MainActivity;

public class AddEvent extends AppCompatActivity {
    Button cancel;
    Button create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent barIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(barIntent);
            }
        });
        create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent barIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(barIntent);
            }
        });
    }
}
