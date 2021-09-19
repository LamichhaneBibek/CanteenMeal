package com.bcrs.adminapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<recyclerNewOrders> recyclerNewordersList;
    RecycAdapter recycAdapter;

    ImageView btnLogout;
    FirebaseAuth mAuth;
    TabLayout tab_Layout;
    ViewPager2 pager2;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerNewordersList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //passing  data to modal class
        for(int i=0; i<=10; i++){
            recyclerNewOrders   recyclerNewOrders = new recyclerNewOrders("Bibek Lamichhane"+i,"1"+i, "250"+i, "15:30"+i, "i would like to have hot food"+i);
            recyclerNewordersList.add(recyclerNewOrders);
        }

        recycAdapter = new RecycAdapter(recyclerNewordersList);
        recyclerView.setAdapter(recycAdapter);

        tab_Layout = findViewById(R.id.tabLayout);
        pager2 = findViewById(R.id.viewPager2);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter);

        tab_Layout.addTab(tab_Layout.newTab().setText("New Orders"));
        tab_Layout.addTab(tab_Layout.newTab().setText("Ongoing Orders"));
        tab_Layout.addTab(tab_Layout.newTab().setText("Past Orders"));


        btnLogout = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();
        //  btnUploadNotice= findViewById(R.id.btnUploadNotice);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mAuth.signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
        // btnUploadNotice.setOnClickListener(this);

        tab_Layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tab_Layout.selectTab(tab_Layout.getTabAt(position));
            }
        });
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser user = mAuth.getCurrentUser();
//        if(user == null){
//            startActivity(new Intent(MainActivity.this, LoginActivity.class));
//        }
//    }
}