package com.example.paragastask1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PersonalProjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_projects);

        if(getIntent().hasExtra("ProjectsList"))
            ((TextView) findViewById(R.id.personalProjectsList))
                    .setText(getIntent().getStringExtra("ProjectsList"));
    }
}