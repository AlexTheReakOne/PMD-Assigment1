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
        TextView txt2 = findViewById(R.id.textView2);


        String bar1 = getString(R.string.bar1);
        String bar2 = getString(R.string.bar2);
        String bar3 = getString(R.string.bar3);
        String bar4 = getString(R.string.bar4);
        String bar5 = getString(R.string.bar5);

        ArrayList<String> myList = new ArrayList<String>();
        myList.add(bar1);
        myList.add(bar2);
        myList.add(bar3);
        myList.add(bar4);
        myList.add(bar5);
        ArrayList<Integer> picsBar = new ArrayList<Integer>();

        //ImageView pics = view.findViewById(R.id.imageView2);
        picsBar.add(R.drawable.bar1);
        picsBar.add(R.drawable.bar2);
        picsBar.add(R.drawable.bar3);
        picsBar.add(R.drawable.bar4);
        picsBar.add(R.drawable.bar5);

        ArrayList<String> barsDescriton = new ArrayList<String>();

        String bar1Des = getString(R.string.bar1Desc);
        String bar2Des = getString(R.string.bar2Desc);
        String bar3Des = getString(R.string.bar3Desc);
        String bar4Des = getString(R.string.bar4Desc);
        String bar5Des = getString(R.string.bar5Desc);

        barsDescriton.add(bar1Des);
        barsDescriton.add(bar2Des);
        barsDescriton.add(bar3Des);
        barsDescriton.add(bar4Des);
        barsDescriton.add(bar5Des);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //The key argument here must match that used in the other activity
            Integer id = extras.getInt("position");
            txt.setText(myList.get(id));
            img.setImageResource(picsBar.get(id));
            txt2.setText(myList.get(id));
        }
    }
}