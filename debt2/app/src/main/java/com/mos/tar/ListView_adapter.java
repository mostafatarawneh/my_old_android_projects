package com.mos.tar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mos.com.R;

import java.util.List;

public class ListView_adapter extends ArrayAdapter<com.mos.tar.debt_data> {

    private int resourceLayout;
    private Context mContext;
    private Context context;


    public ListView_adapter(Context context, int resource, List<com.mos.tar.debt_data> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        com.mos.tar.debt_data p = getItem(position);

        if (p != null) {
            TextView name =  v.findViewById(R.id.name);
            TextView amount = v.findViewById(R.id.amount);
            TextView notes =  v.findViewById(R.id.note);
            Button Delbt =  v.findViewById(R.id.delete_button);


            if (name != null) {
                name.setText(String.valueOf(p.getName()));
            }
            if (amount != null) {
                amount.setText(String.valueOf(p.getAmount()));
            }

            if (notes != null) {
                notes.setText(String.valueOf(p.getNote()));
            }

            if (Delbt != null) {
                Delbt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Hello World", Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }

        return v;

    }
}

