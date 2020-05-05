package com.example.game.dodog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.example.game.R;

public class DodogStart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodog_start);
        ImageView imageView = findViewById(R.id.dodogImg);
        Animation animation = AnimationUtils.loadAnimation(DodogStart.this,R.anim.rotate);
        imageView.startAnimation(animation);
        imageView.setVisibility(View.VISIBLE);
    }
}
