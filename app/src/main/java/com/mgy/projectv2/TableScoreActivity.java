package com.mgy.projectv2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableScoreActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_score);

        ListView scoreTable = findViewById(R.id.score_table);

        String nameRes = getResources().getString(R.string.name);
        String scoreRes = getResources().getString(R.string.score);

        SharedPreferences sp = getSharedPreferences("details", MODE_PRIVATE);
        ArrayList<User> users = null;
        try {
            users = (ArrayList<User>) ObjectSerializer.deserialize(sp.getString("users", ObjectSerializer.serialize(new ArrayList<String>())));
        } catch (IOException e) {
            e.printStackTrace(); } catch (ClassNotFoundException e) { e.printStackTrace(); }


        int current_level = getIntent().getIntExtra("level", -1);
        List<Map<String, Object>> userData = new ArrayList<>();

        for (int i=0 ; i < users.size() ; i++)
        {
            if(users.get(i).scoreArray[current_level] != 0)
            {
                HashMap<String, Object> userHashMap = new HashMap<>();
                userHashMap.put("name", users.get(i).name);
                userHashMap.put("score", scoreRes + users.get(i).scoreArray[current_level]);

                userData.add(userHashMap);
            }
        }

        String[] from = {"name", "score"};
        int[] to = {R.id.name_TextView, R.id.score_TextView};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, userData, R.layout.users_and_score, from, to);

        scoreTable.setAdapter(simpleAdapter);

    }
}
