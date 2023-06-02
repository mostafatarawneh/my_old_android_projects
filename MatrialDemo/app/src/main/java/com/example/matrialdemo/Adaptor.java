package com.example.matrialdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptor  extends RecyclerView.Adapter<Adaptor.MyviewHolder> {

    ArrayList<User> arr =new ArrayList<>();
  RecyclerViewClickInterface recyclerViewClickInterface;

    public Adaptor(ArrayList<User> arr) {
        this.arr = arr;
       // this.recyclerViewClickInterface=recyclerViewClickInterface;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler,null,false);
         MyviewHolder mv =new MyviewHolder(v);
        return mv;
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
    User t = arr.get(position);
    holder.tv.setText(t.getName());
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    class MyviewHolder extends RecyclerView.ViewHolder  {
        TextView tv;
        RecyclerViewClickInterface recyclerViewClickInterface;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_username);

        }

    }

}
