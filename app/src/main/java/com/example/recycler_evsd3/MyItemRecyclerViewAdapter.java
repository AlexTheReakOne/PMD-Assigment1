package com.example.recycler_evsd3;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recycler_evsd3.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.recycler_evsd3.databinding.FragmentItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<String> mValues;
    private final List<String> mValuesDes;
    private final List<Integer> pics;
   // private List<String> myData;
    private LayoutInflater myInflater;
    private ItemClickListener myClickListener;





    public MyItemRecyclerViewAdapter(Bars bars, List<String> items, ArrayList<Integer> picsBar,List<String> itemsDes ) {
        this.mValues = items;
        this.pics=picsBar;
        this.myInflater =LayoutInflater.from(bars.getActivity());
        this.mValuesDes = itemsDes;
    }
    public MyItemRecyclerViewAdapter(BnB bnb, List<String> items, List<Integer> pics,List<String> itemsDes) {
        this.mValues = items;
        this.pics = pics;
        this.myInflater =LayoutInflater.from(bnb.getActivity());
        this.mValuesDes = itemsDes;
    }
    public MyItemRecyclerViewAdapter(Bus bus, List<String> items,List<Integer> pics,List<String> itemsDes) {
        this.mValues = items;
        this.pics = pics;
        this.myInflater =LayoutInflater.from(bus.getActivity());
        this.mValuesDes = itemsDes;
    }
    void setClickListener(ItemClickListener itemClickListener){
        this.myClickListener = itemClickListener;
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }

    @Override
    public  int getItemCount(){ return  mValues.size();}

    String getItem(int id){
        return mValues.get(id);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View view = myInflater.inflate(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position));
        holder.mContentView.setText(mValues.get(position));
        holder.pItem = pics.get(position);
                // Drawable d = getResources().getDrawable(pics.get(position));
        holder.pimageView.setImageResource(pics.get(position));

    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView mIdView;
        public final ImageView pimageView;
        public final TextView mContentView;
        public Integer pItem;
        public String mItem;

        public ViewHolder(FragmentItemBinding binding)  {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
            pimageView = binding.imageView2;
            //pItem = binding.imageView2;
            binding.getRoot().setOnClickListener(this);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View view) {
            if (myClickListener != null) myClickListener.onItemClick(view,getAbsoluteAdapterPosition());

        }
    }
}