package com.example.game;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment,null);
        TabHost tabHost = view.findViewById(android.R.id.tabhost);
        tabHost.setup();
        View layout = inflater.inflate(R.layout.tab_woman,tabHost.getTabContentView());
        int[] imgids = new int[]{R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
                R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};
        String[] title = new String[]{"1","2","3","1","2","3","1","2","3","1","2","3"};
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (int i=0;i<imgids.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("image",imgids[i]);
            map.put("name",title[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(layout.getContext(),list,R.layout.chat,new String[]{"name","image"},new int[]{R.id.headtitle,R.id.headimg});
        final ListView listView = layout.findViewById(R.id.womanChat);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(listView.getContext(),map.get("name").toString(),Toast.LENGTH_LONG).show();
            }
        });


        inflater.inflate(R.layout.tab_man,tabHost.getTabContentView());
        inflater.inflate(R.layout.tab_follow,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tab_woman").setIndicator("女").setContent(R.id.left));
        tabHost.addTab(tabHost.newTabSpec("tab_man").setIndicator("男").setContent(R.id.right));
        tabHost.addTab(tabHost.newTabSpec("tab_follow").setIndicator("特别关注").setContent(R.id.follow));
        return view;
    }

}
