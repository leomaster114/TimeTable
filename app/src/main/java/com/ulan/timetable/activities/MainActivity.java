package com.ulan.timetable.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


import com.ulan.timetable.adapters.FragmentsTabAdapter;
import com.ulan.timetable.fragments.FridayFragment;
import com.ulan.timetable.fragments.MondayFragment;
import com.ulan.timetable.fragments.ThursdayFragment;
import com.ulan.timetable.fragments.TuesdayFragment;
import com.ulan.timetable.fragments.WednesdayFragment;
import com.ulan.timetable.R;
import com.ulan.timetable.model.Subject;
import com.ulan.timetable.utils.AlertDialogsHelper;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity{

    private FragmentsTabAdapter adapter;
    private ViewPager viewPager;
//    private boolean switchSevenDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAll();
    }

    private void initAll() {
        PreferenceManager.setDefaultValues(this, R.xml.settings, false);
        setupFragments();
        setupCustomDialog();
    }

    private void setupFragments() {
        adapter = new FragmentsTabAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        adapter.addFragment(new MondayFragment(), getResources().getString(R.string.monday));
        adapter.addFragment(new TuesdayFragment(), getResources().getString(R.string.tuesday));
        adapter.addFragment(new WednesdayFragment(), getResources().getString(R.string.wednesday));
        adapter.addFragment(new ThursdayFragment(), getResources().getString(R.string.thursday));
        adapter.addFragment(new FridayFragment(), getResources().getString(R.string.friday));
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(day == 1 ? 6 : day-2, true);
        tabLayout.setupWithViewPager(viewPager);
    }

    
    private void setupCustomDialog() {
        ArrayList<Subject> subjectArrayList = new ArrayList<>();
        subjectArrayList.add(new Subject("Lap trinh java","Nguyen Manh Son","402-A2","9:00","11:00", Color.GREEN,"monday"));
        subjectArrayList.add(new Subject("Lap trinh C++","Nguyen Manh Son","402-A2","9:00","11:00", Color.YELLOW,"tuesday"));
        subjectArrayList.add(new Subject("Lap trinh Android","Nguyen Manh Son","402-A2","9:00","11:00", Color.LTGRAY,"thursday"));
        subjectArrayList.add(new Subject("Lap trinh C#","Nguyen Manh Son","402-A2","9:00","11:00", Color.BLUE,"monday"));
        AlertDialogsHelper.getAddSubjectDialog(MainActivity.this, subjectArrayList, adapter, viewPager);
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
