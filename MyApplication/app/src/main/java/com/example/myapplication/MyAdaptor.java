package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.BookViewHolder> {
    ArrayList<Book> arr;

    public MyAdaptor(ArrayList<Book> arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null,false);
     BookViewHolder bo = new BookViewHolder(v);
        return bo;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        Book book = arr.get(position);
        holder.tilte.setText(book.getTitle());
        holder.year.setText(book.getYear());
        holder.author.setText(book.getAuthor());

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    class BookViewHolder extends RecyclerView.ViewHolder{
        TextView tilte,author,year;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            tilte = itemView.findViewById(R.id.titletxt);
            author=itemView.findViewById(R.id.authortxt);
            year=itemView.findViewById(R.id.yeartxt);
        }
    }

}
