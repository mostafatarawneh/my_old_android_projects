package com.mos.tar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mos.tar.DataBaseStuff.infoDataBaseAdapter;
import com.mos.com.R;

import java.util.ArrayList;
import java.util.List;

public class recyclerAdapter extends RecyclerView.Adapter<com.mos.tar.infoViewHolder> implements Filterable {

    private Context context;
    private ArrayList<com.mos.tar.debt_data> debtList;
    private infoDataBaseAdapter mDatabase;
    private ArrayList<com.mos.tar.debt_data> debtListFull;


    public recyclerAdapter(Context context, ArrayList<com.mos.tar.debt_data> debtList) {
        this.context = context;
        this.debtList = debtList;
        debtListFull = new ArrayList<>(debtList);
        mDatabase = new infoDataBaseAdapter(context);
    }


    @Override
    public infoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list, parent, false);
        infoViewHolder viewHolder = new infoViewHolder(itemView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(com.mos.tar.infoViewHolder holder, int position) {
        final com.mos.tar.debt_data debtInfo = debtList.get(position);

        holder.name.setText(debtInfo.getName());
        holder.amount.setText(String.valueOf(debtInfo.getAmount()));
        holder.notes.setText(debtInfo.getNote());

//        holder.setListeners();
        holder.deleterow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
                mDatabase.deleteEntry(debtInfo.getId());
//                Toast.makeText(context.getApplicationContext(), position, Toast.LENGTH_LONG).show();
                Log.d("القيمة التي مررت", String.valueOf(position));
                //TODO : add here advertisement


            }
        });
    }

    @Override
    public int getItemCount() {
        return debtList.size();
    }


    public void removeItem(int position) {
        debtList.remove(position);
        notifyItemRemoved(position);
        mDatabase.deleteEntry(position);
        notifyItemRangeChanged(position, debtList.size());
//TODO : add here advertisement

    }


    @Override
    public Filter getFilter() {
        return debtfilter;
    }

    private Filter debtfilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<com.mos.tar.debt_data> FliteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                FliteredList.addAll(debtListFull);
            } else {
                String FliterdPattren = constraint.toString().toLowerCase().trim();
                for (com.mos.tar.debt_data item : debtListFull) {
                    if (item.getName().toLowerCase().contains(FliterdPattren))
                        FliteredList.add(item);
                }
            }
            FilterResults results = new FilterResults();
            results.values = FliteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            debtList.clear();
            debtList.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };
}
