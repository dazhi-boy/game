package com.example.game.balloon;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.game.R;

import java.util.Timer;
import java.util.TimerTask;

public class BalloonStart extends Activity {
    private GameView gameView;
    private int winWidth;
    private int winHeight;
    private boolean right = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        gameView.setBackgroundResource(R.drawable.bg);
        setContentView(gameView);
        //获取屏幕宽高
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        winWidth = metrics.widthPixels;
        winHeight = metrics.heightPixels;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (gameView.x>winWidth-200) right = false;
                if (gameView.x<0) right = true;
                if (right) gameView.x+=5;
                else gameView.x-=5;
                handler.sendEmptyMessage(0x123);
            }
        },0,15);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123){
                gameView.invalidate();
            }
        }
    };

}
