package com.example.recycler_evsd3;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Bars  extends Fragment  implements MyItemRecyclerViewAdapter.ItemClickListener{
    MyItemRecyclerViewAdapter myAdapter;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Bars() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ItemFragment newInstance(int columnCount) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_bars, container, false);
        //RecyclerView rv = findViewById(R.id.list3);
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

        String bar1Des = getString(R.string.bar1);
        String bar2Des = getString(R.string.bar2);
        String bar3Des = getString(R.string.bar3);
        String bar4Des = getString(R.string.bar4);
        String bar5Des = getString(R.string.bar5);

        barsDescriton.add(bar1Des);
        barsDescriton.add(bar2Des);
        barsDescriton.add(bar3Des);
        barsDescriton.add(bar4Des);
        barsDescriton.add(bar5Des);


        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                myAdapter = new MyItemRecyclerViewAdapter(this, myList,picsBar,barsDescriton);

            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(this, myList,picsBar,barsDescriton));
            myAdapter.setClickListener(this);
            recyclerView.setAdapter(myAdapter);
        }
        return view;
    }

    @Override
    public void onItemClick(View view, int position) {

        String bar = myAdapter.getItem(position);

        Toast.makeText(this.getContext(),
                "You clicked on "+bar,
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(view.getContext(),Bars2.class);
        intent.putExtra("position",position);
        startActivity(intent);
         Toast.makeText(this.getContext(),"you clicked on "+ myAdapter.getItem(position)+"on position"+ position,Toast.LENGTH_SHORT).show();
    }
}
