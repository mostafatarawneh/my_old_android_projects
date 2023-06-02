package com.mos.cardviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdaptor extends BaseAdapter {
    Context c;
    ArrayList<CardViewExam> cve;
    public CustomAdaptor(Context c, ArrayList<CardViewExam> cve){
        this.c = c;
        this.cve = cve;
    }
    @Override
    public int getCount() {
        return cve.size();
    }

    @Override
    public CardViewExam getItem(int position) {
        return cve.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v==null){
            v= LayoutInflater.from(c).inflate(R.layout.activity_main,null,false);
        }
        CardViewExam cd = cve.get(position);
        TextView body = v.findViewById(R.id.textView);
        ImageView img = v.findViewById(R.id.imageView);
        body.setText(cd.getBody());
        img.setImageResource(cd.getImg());
        return v;
    }
}
