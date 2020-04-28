package com.example.game.balloon;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;


public class BalloonStart extends Activity {
    GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                gameView.x++;
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
