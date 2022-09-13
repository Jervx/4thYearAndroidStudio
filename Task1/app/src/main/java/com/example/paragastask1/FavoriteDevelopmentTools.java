package com.example.paragastask1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FavoriteDevelopmentTools extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_development_tools);

        if(getIntent().hasExtra("DevToolsList"))
            ( (TextView) findViewById(R.id.devToolsList))
                    .setText(getIntent().getExtras().getString("DevToolsList"));
    }
}