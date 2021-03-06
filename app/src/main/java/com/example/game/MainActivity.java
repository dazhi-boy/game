package com.example.game;

import android.app.Fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView chat = (ImageView)findViewById(R.id.chat);
        ImageView message = (ImageView)findViewById(R.id.message);
        ImageView find = (ImageView)findViewById(R.id.find);
        ImageView me = (ImageView)findViewById(R.id.me);
        ImageView game = findViewById(R.id.game);

        chat.setOnClickListener(l);
        message.setOnClickListener(l);
        find.setOnClickListener(l);
        me.setOnClickListener(l);
        game.setOnClickListener(l);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment f = new ChatFragment();
        ft.replace(R.id.fragment,f);
        ft.commit();
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment f = null;
            switch (v.getId()) {
                case R.id.chat:
                    f = new ChatFragment();
                    break;
                case R.id.message:
                    f = new MessageFragment();
                    break;
                case R.id.find:
                    f = new FindFragment();
                    break;
                case R.id.me:
                    f = new MeFragment();
                    break;
                case R.id.game:
                    f = new GameFragment();
                    break;
                default:
                    break;
            }
            ft.replace(R.id.fragment,f);
            ft.commit();
        }
    };
}
