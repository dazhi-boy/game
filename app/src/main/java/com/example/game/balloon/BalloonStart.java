package com.example.game.balloon;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.game.R;

import java.util.Timer;
import java.util.TimerTask;

public class BalloonStart extends Activity {
    private GameView gameView;
    private int winWidth;
    private int winHeight;
    public double speed = 7;
    private boolean right = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        gameView.setBackgroundResource(R.drawable.air);
        setContentView(gameView);
        //获取屏幕宽高
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        winWidth = metrics.widthPixels;
        winHeight = metrics.heightPixels;
        gameView.setWin(winWidth,winHeight,this);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (gameView.x>winWidth-200) right = false;
                if (gameView.x<0) right = true;
                if (right) gameView.x+=speed;
                else gameView.x-=speed;
                if (gameView.launch) gameView.rocket_y -=15;
                if (gameView.rocket_y<0) {
                    gameView.rocket_y = winHeight-300;
                    gameView.launch = false;
                }
                //判断火箭和气球是否相撞
                if (Math.abs(gameView.x+100-winWidth/2)<100&&gameView.rocket_y>0&&gameView.rocket_y<400)
                    gameView.again = true;

                handler.sendEmptyMessage(0x123);
            }
        },0,15);
        //监控屏幕点击事件
        gameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameView.launch = true;
            }
        });
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
