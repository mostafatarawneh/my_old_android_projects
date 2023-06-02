package com.mos.examlble4adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdaptor extends BaseAdapter {
    private ArrayList<Pofile> data;
    Context c;

    public CustomAdaptor(ArrayList<Pofile> data, Context c) {
        this.data = data;
        this.c = c;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Pofile getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView tv_following,tv_posts,tv_followers,tv_name,tv_bio;
        ImageView img;
        if (v==null){
            v=LayoutInflater.from(c).inflate(R.layout.row,null,false);
                   }
        tv_bio =v.findViewById(R.id.tv_bio);
        tv_followers=v.findViewById(R.id.tv_number_followers);
        tv_following=v.findViewById(R.id.tv_number_following);
        tv_name=v.findViewById(R.id.tv_usrname);
        img =v.findViewById(R.id.imageView);
        Pofile p = getItem(position);
        tv_bio.setText(p.getBio());
        tv_followers.setText(p.getFollowers()+"");
        tv_following.setText(p.getFollowing()+"");
        tv_name.setText(p.getName());
        img.setImageResource(R.drawable.ic_user);

        return v;
    }
}
