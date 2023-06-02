package com.example.recyclerdemoaga;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Radaptore extends RecyclerView.Adapter<Radaptore.myviewadptor> {
    ArrayList <Contries> ar =new ArrayList();

    public Radaptore(ArrayList ar) {
        this.ar = ar;
    }

    @NonNull
    @Override
    public myviewadptor onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item,null,false);
        myviewadptor m =new myviewadptor(v);
        return m;
    }

    @Override
    public int getItemCount() {
        return ar.size();
    }

    @Override
    public void onBindViewHolder(@NonNull myviewadptor holder, int position) {
        Contries c = ar.get(position);
        holder.tv.setText(c.getS());

    }

    public class myviewadptor extends RecyclerView.ViewHolder{
        TextView tv;

        public myviewadptor(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.textView);
        }
    }
}

