package com.mos.fulldemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptore extends RecyclerView.Adapter<Adaptore.UserViewHolder> {
  ArrayList<User> arr =new ArrayList<>();

    public Adaptore(ArrayList<User> arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_recycler,null,false);
        UserViewHolder usr=new UserViewHolder(v);


        return usr;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User u = arr.get(position);
        holder.tv_username.setText(u.getUsername());
        holder.tv_password.setText(u.getPassword());
        holder.tv_work.setText(u.getWork());
        holder.tv_age.setText(u.getAge());
        holder.img.setImageResource(u.getImg());

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
     TextView tv_username,tv_password,tv_age,tv_work;
     ImageView img;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_age=itemView.findViewById(R.id.tv_age);
            tv_username=itemView.findViewById(R.id.tv_username);
            tv_password=itemView.findViewById(R.id.tv_password);
            tv_work=itemView.findViewById(R.id.tv_work);
            img=itemView.findViewById(R.id.imageView);
        }
    }
}
