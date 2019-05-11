package com.example.dashboard;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    RecyclerView recyclerView;
    List<item> mData;
    MenuAdapter adapter;

    //fragment code
    public static final int DASHBOARD_CODE = 0;
    public static final int WIFI_CODE = 1;
    public static final int SETTING_CODE = 2;
    public static final int PROFILE_CODE = 3;
    public static final int SHOPING_CODE = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        recyclerView = findViewById(R.id.rv_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mData = new ArrayList<>();

        mData.add(new item(R.drawable.ic_dashboard_black_24dp,DASHBOARD_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_person_black_24dp,PROFILE_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_wifi_black_24dp,WIFI_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_shopping_cart_black_24dp,SHOPING_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_settings_black_24dp,SETTING_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_dashboard_black_24dp,DASHBOARD_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_person_black_24dp,PROFILE_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_wifi_black_24dp,WIFI_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_shopping_cart_black_24dp,SHOPING_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_settings_black_24dp,SETTING_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_dashboard_black_24dp,DASHBOARD_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_person_black_24dp,PROFILE_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_wifi_black_24dp,WIFI_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_shopping_cart_black_24dp,SHOPING_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_settings_black_24dp,SETTING_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_person_black_24dp,PROFILE_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_wifi_black_24dp,WIFI_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_shopping_cart_black_24dp,SHOPING_CODE, "Dashboard"));
        mData.add(new item(R.drawable.ic_settings_black_24dp,SETTING_CODE, "Dashboard"));
        adapter = new MenuAdapter(this, mData);
        recyclerView.setAdapter(adapter);



        //dashboard

        DashboardFrag dashboardFrag = new DashboardFrag();

        fragmentTransaction.replace(R.id.container, dashboardFrag);
        fragmentTransaction.commit();
    }
}
