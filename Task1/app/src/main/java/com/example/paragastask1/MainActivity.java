package com.example.paragastask1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button friendsBtn = findViewById(R.id.myFriendsBtn);
        Button devToolsBtn = findViewById(R.id.devToolsBtn);
        Button personalProjectsBtn = findViewById(R.id.personalProjectsBtn);

        friendsBtn.setOnClickListener(e -> {
            Intent Friends = new Intent(getApplicationContext(), Friends.class);
            Friends.putExtra("FriendsList",
                    "MY FRIENDS\n\nRojan Yepes\n\nAndrei Castro\n\nZalven Dayao\n\nPatrick Legaspi\n\nJohnnel Magtalas\n\nJamiena Franza\n\nDominic Lagata\n\nPatrick Legaspi");
            startActivity(Friends);
        });

        devToolsBtn.setOnClickListener(e -> {
            Intent DevTools = new Intent( getApplicationContext(), FavoriteDevelopmentTools.class);
            DevTools.putExtra("DevToolsList",
                    "FAVORITE DEV TOOLS\n\nVisual Studio Code\n\nIntellij\n\nFigma\n\nDataGrip\n\nMongoDB Compass\n\nMySQL workbench\n\nGithub\n\nAndroid Studio\n\nPostman");
            startActivity(DevTools);
        });

        personalProjectsBtn.setOnClickListener(e -> {
            Intent PersonalProjects = new Intent( getApplicationContext(), PersonalProjects.class);
            PersonalProjects.putExtra("ProjectsList",
                    "MY PROJECTS\n\nAstig Ecommerce\n\nUnsaid Feelings\n\nBelgian Security Agency\n\nInfinite Void Game\n\nSimple Text Editor\n\nCSO\n\nTtctacToe Vanilla Js\n\nPOS in C");
            startActivity(PersonalProjects);
        });

    }
}