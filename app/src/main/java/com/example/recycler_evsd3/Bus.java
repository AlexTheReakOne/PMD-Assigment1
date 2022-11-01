package com.example.recycler_evsd3;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recycler_evsd3.placeholder.PlaceholderContent;

import java.util.ArrayList;

public class Bus extends Fragment implements MyItemRecyclerViewAdapter.ItemClickListener{
    MyItemRecyclerViewAdapter myAdapter;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public Bus() {
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
        View view = inflater.inflate(R.layout.activity_bus, container, false);

        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Bus 1");
        myList.add("Bus 2");
        myList.add("Bus 3");
        myList.add("Bus 4");
        ArrayList<Integer> picsBus = new ArrayList<Integer>();

        //ImageView pics = view.findViewById(R.id.imageView2);
        picsBus.add(R.drawable.bar1);
        picsBus.add(R.drawable.bar2);
        picsBus.add(R.drawable.bar3);
        picsBus.add(R.drawable.bar4);
        picsBus.add(R.drawable.bar5);

        ArrayList<String> busDescriton = new ArrayList<String>();

        String bar1Des = getString(R.string.bar1);
        String bar2Des = getString(R.string.bar2);
        String bar3Des = getString(R.string.bar3);
        String bar4Des = getString(R.string.bar4);
        String bar5Des = getString(R.string.bar5);

        busDescriton.add(bar1Des);
        busDescriton.add(bar2Des);
        busDescriton.add(bar3Des);
        busDescriton.add(bar4Des);
        busDescriton.add(bar5Des);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                myAdapter = new MyItemRecyclerViewAdapter(this, myList,picsBus,busDescriton);
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(this, myList,picsBus,busDescriton));
            myAdapter.setClickListener(this);
            recyclerView.setAdapter(myAdapter);
        }
        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this.getContext(),"you clicked on "+ myAdapter.getItem(position)+"on position"+ position,Toast.LENGTH_SHORT).show();
    }
}