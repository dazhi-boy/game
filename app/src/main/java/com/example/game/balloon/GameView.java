package com.example.game.balloon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import com.example.game.R;

import java.util.Timer;
import java.util.TimerTask;

public class GameView extends View {
    Paint paint = new Paint();
    public int x;
    public GameView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setTextSize(80);
        canvas.drawText("fafsafdsfds",100,100,paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.balloon);
        canvas.drawBitmap(bitmap,null,new RectF(x+200,200,x+400,400),null);
//        x++;
//        canvas.drawBitmap(bitmap,200,200,paint);
    }
}
