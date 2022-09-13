package com.example.paragastask1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Friends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        if(getIntent().hasExtra("FriendsList"))
            ( (TextView) findViewById(R.id.friendsListTextView))
                    .setText(getIntent().getExtras().getString("FriendsList"));
    }
}