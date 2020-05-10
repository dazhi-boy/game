package com.example.game.webSocket;

import android.content.Context;
import android.widget.Toast;

public class Util {
    public static final String ws = "ws://192.168.1.5:8080/socketServer/lisi";//websocket测试地址

    public static void showToast(Context ctx, String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
    }
}
