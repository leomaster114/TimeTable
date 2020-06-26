package com.ulan.timetable.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.ulan.timetable.R;
import com.ulan.timetable.utils.DbHelper;


public class PersonInfoActivity extends AppCompatActivity {

    private Context context = this;
    private ListView listView;
    private DbHelper db;
    private int listposition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personinfo);
        initAll();
    }

    private void initAll() {

    }



}
