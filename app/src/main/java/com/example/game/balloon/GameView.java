package com.example.game.balloon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.game.R;

public class GameView extends View {
    BalloonStart balloonStart;

    private int sum;    //统计一共打了几个气球
    Paint paint = new Paint();
    public int cont = 5;
    public int x;
    public int rocket_y;
    private int width = 300;
    public boolean launch = false;
    public boolean again = false;

    private int winWidth;
    private int winHeight;
    public GameView(Context context) {
        super(context);
    }

    public void setWin(int winWidth, int winHeight, BalloonStart balloonStart){
        this.winWidth = winWidth;
        this.winHeight = winHeight;
        rocket_y = winHeight-300;
        this.balloonStart = balloonStart;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setTextSize(150);
        paint.setColor(Color.BLUE);

        //画一个赞的图标
        Bitmap bitmapGood= BitmapFactory.decodeResource(getResources(),R.drawable.a12);
        canvas.drawBitmap(bitmapGood,null,new RectF(25,25,175,175),paint);
        canvas.drawText(""+sum,200,150,paint);

        if (again) {
            //画一个爆炸的图
            Bitmap bitmapBomb= BitmapFactory.decodeResource(getResources(),R.drawable.bomb);
            canvas.drawBitmap(bitmapBomb,null,new RectF(winWidth/2-width/2,300-width/2,winWidth/2+width/2,300+width/2),paint);
            cont--;
            width +=10;
            if (cont==0) {
                cont = 5;
                width =300;
                again = false;
                x = 0;
                rocket_y = winHeight-300;
                launch = false;
                sum++;
                balloonStart.speed+=0.2;
            }

        } else {
            //画一个气球
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.balloon);
            canvas.drawBitmap(bitmap,null,new RectF(x,200,x+200,400),paint);

            //画一个火箭
            Bitmap bitmapRocker = BitmapFactory.decodeResource(getResources(),R.drawable.rocket);
            canvas.drawBitmap(bitmapRocker,null,new RectF(winWidth/2-50,rocket_y,winWidth/2+50,rocket_y+200),paint);
        }
    }
}
