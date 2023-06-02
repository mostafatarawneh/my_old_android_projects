package com.mos.tar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mos.com.R;

public class infoViewHolder extends RecyclerView.ViewHolder {
    public TextView name, amount, notes;
    public ImageButton deleterow;

    public infoViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        amount = (TextView) itemView.findViewById(R.id.amount);
        notes = (TextView) itemView.findViewById(R.id.note);
        deleterow = (ImageButton) itemView.findViewById(R.id.delete_button);
    }
}
