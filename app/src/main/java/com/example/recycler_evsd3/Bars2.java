package com.example.recycler_evsd3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Bars2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bars2);
        TextView txt = findViewById(R.id.textView);
        ImageView img = findViewById(R.id.imageView3);
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Bar 1");
        myList.add("Bar 2");
        myList.add("Bar 3");
        myList.add("Bar 4");
        myList.add("Bar 5");
        ArrayList<Integer> myImages = new ArrayList<Integer>();
        myImages.add(R.drawable.bar1);
        myImages.add(R.drawable.bar2);
        myImages.add(R.drawable.bar3);
        myImages.add(R.drawable.bar4);
        myImages.add(R.drawable.bar5);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //The key argument here must match that used in the other activity
            Integer id = extras.getInt("position");
            txt.setText(myList.get(id));
            img.setImageResource(myImages.get(id));
        }
    }
}