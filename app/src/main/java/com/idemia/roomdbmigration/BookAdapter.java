package com.idemia.roomdbmigration;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idemia.roomdbmigration.db.entitiy.book.Book;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    Activity context;
    List<Book> bookList;

    public BookAdapter(Activity context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.text_id.setText(String.valueOf(bookList.get(position).getId()));
        holder.text_name.setText(bookList.get(position).getName());
        holder.text_author.setText(bookList.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        TextView text_id;
        TextView text_name;
        TextView text_author;

        public BookViewHolder(@NotNull View itemView) {
            super(itemView);
            text_id = itemView.findViewById(R.id.text_id);
            text_name = itemView.findViewById(R.id.text_name);
            text_author = itemView.findViewById(R.id.text_author);
        }
    }
}
