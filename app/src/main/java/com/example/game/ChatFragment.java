package com.example.game;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

public class ChatFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment,null);
        TabHost tabHost = view.findViewById(android.R.id.tabhost);
        tabHost.setup();
        inflater.inflate(R.layout.tab_woman,tabHost.getTabContentView());
        inflater.inflate(R.layout.tab_man,tabHost.getTabContentView());
        inflater.inflate(R.layout.tab_follow,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tab_woman").setIndicator("女").setContent(R.id.left));
        tabHost.addTab(tabHost.newTabSpec("tab_man").setIndicator("男").setContent(R.id.right));
        tabHost.addTab(tabHost.newTabSpec("tab_follow").setIndicator("特别关注").setContent(R.id.follow));
        return view;
    }

}
