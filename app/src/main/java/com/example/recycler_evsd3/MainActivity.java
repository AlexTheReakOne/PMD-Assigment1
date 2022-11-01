package com.example.recycler_evsd3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements MyItemRecyclerViewAdapter.ItemClickListener{

    TabLayout tabLayout;
    ImageView banner;
    MyItemRecyclerViewAdapter myAdapter;
    public RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        banner= findViewById(R.id.imageView);



        //step3  setup the first fragment on start
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, new BnB()).commit();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //step4 switch positions on tab
                switch (tab.getPosition()){
                    case 0:
                        //banner.setImageResource(R.drawable.bar_banner);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout,
                                        new BnB()).commit();
                        break;
                    case 1:
                        //banner.setImageResource(R.drawable.bus_banner);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout,
                                        new Bus()).commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frameLayout,
                                        new Bars()).commit();
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,"you clicked on "+
                myAdapter.getItem(position)+"on position"+
                position,Toast.LENGTH_SHORT).show();
    }
}