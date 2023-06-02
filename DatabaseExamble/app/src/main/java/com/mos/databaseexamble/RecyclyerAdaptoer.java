package com.mos.databaseexamble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclyerAdaptoer extends RecyclerView.Adapter<RecyclyerAdaptoer.MyViewHolder> {
    ArrayList<Car> car_array=new ArrayList<>();

    public RecyclyerAdaptoer(ArrayList<Car> car_array) {
        this.car_array = car_array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recylcer,null,false);
        MyViewHolder m = new MyViewHolder(v);


        return m;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Car c = car_array.get(position);
        holder.img.setImageResource(c.getImg());
        holder.tv_color.setText(c.getColor());
        holder.tv_model.setText(c.getModel());
        holder.tv_dpl.setText(c.getDistanceperLiter()+"");
    }

    @Override
    public int getItemCount() {
        return car_array.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_model,tv_dpl,tv_color;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_model=itemView.findViewById(R.id.custom_model);
            tv_color=itemView.findViewById(R.id.custom_color);
            tv_model=itemView.findViewById(R.id.custom_dpl);
            img=itemView.findViewById(R.id.custom_img);
        }
    }


}
