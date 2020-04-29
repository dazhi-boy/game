package com.example.game.balloon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

import com.example.game.R;

public class GameView extends View {
    Paint paint = new Paint();
    public int cont = 5;
    public int x;
    public int rocket_y;
    public boolean launch = false;
    public boolean again = false;

    private int winWidth;
    private int winHeight;
    public GameView(Context context) {
        super(context);
    }

    public void setWin(int winWidth,int winHeight){
        this.winWidth = winWidth;
        this.winHeight = winHeight;
        rocket_y = winHeight-300;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        if (again) {
            //画一个爆炸的图
            Bitmap bitmapBomb= BitmapFactory.decodeResource(getResources(),R.drawable.bomb);
            canvas.drawBitmap(bitmapBomb,null,new RectF(winWidth/2-200,100,winWidth/2+200,500),paint);
            cont--;
            if (cont==0) {
                cont = 5;
                again = false;
                x = 0;
                rocket_y = winHeight-300;
                launch = false;
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
