package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        ImageView image = (ImageView)findViewById(R.id.imageView);
        Animation animation = null;

        int IDngMamaMo = item.getItemId();

        if(R.id.rotate == IDngMamaMo) animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        if(R.id.zoom == IDngMamaMo) animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        if(R.id.fade == IDngMamaMo) animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        if(R.id.mine == IDngMamaMo) animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.mine);

        image.startAnimation(animation);
        return true;
    }
}