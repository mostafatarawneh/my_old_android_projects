package com.mos.fulladapterdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdaptor extends BaseAdapter {
   private ArrayList<String> names ;
     private Context context;

    public CustomAdaptor(ArrayList<String> names, Context context) {
        this.names = names;
        this.context = context;
    }
    public void addItem(String na){
        names.add(na);
    }

    @Override
    public int getCount() {
        return names.size();
    }
    public void editItem(int pos,String s){
        names.set(pos,s);
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v==null){
            v= LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,null,false);
        }
        TextView tv = v.findViewById(android.R.id.text1);
        tv.setText(names.get(position));
        return v;
    }
}
