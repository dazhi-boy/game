package com.example.game;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.game.webSocket.JWebSocketClient;
import org.java_websocket.enums.ReadyState;
import java.net.URI;

public class FindFragment extends Fragment {
    URI uri = URI.create("ws://192.168.43.199:8080/socketServer/hello");
    JWebSocketClient socketClient;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fragment,null);

        Button button = view.findViewById(R.id.testbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    socketClient = new JWebSocketClient(uri);
                    socketClient.connect();
                    while (!socketClient.getReadyState().equals(ReadyState.OPEN)) {
                        System.out.println("------连接中···请稍后");
                        Thread.sleep(500);
                    }
                    socketClient.send("bbb");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
}
