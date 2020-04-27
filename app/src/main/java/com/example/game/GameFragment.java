package com.example.game;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;

import com.example.game.balloon.BalloonStart;
import com.example.game.dodog.DodogStart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_fragment,null);
        ListView listView = view.findViewById(R.id.lvGame);
        int[] imgids = new int[]{R.drawable.balloon,R.drawable.dodog};
        String[] title = new String[]{"balloon","dodog"};
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for (int i=0;i<imgids.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("image",imgids[i]);
            map.put("name",title[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(view.getContext(),list,R.layout.chat,new String[]{"name","image"},new int[]{R.id.headtitle,R.id.headimg});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                String name = (String) map.get("name");
                Intent intent = null;
                switch (name) {
                    case "balloon"://打气球
                        intent = new Intent(view.getContext(), BalloonStart.class);
                        break;
                    case "dodog"://老虎机
                        intent = new Intent(view.getContext(), DodogStart.class);
                        break;
                    default:
                        break;
                }
                startActivity(intent);
            }
        });
        return view;
    }
}
