package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{
    private LayoutInflater layoutInflater;
    private List<Books> books;


    public BookAdapter(Context context, List<Books> books, Integer studentId) {
        // capture required classes for the book adapter
        this.layoutInflater = LayoutInflater.from(context);
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create new view/viewholder to present a single book
        View newView = layoutInflater.inflate(R.layout.onebook, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // attach a book to a view holder
        Books b = books.get(position);
        holder.setBook(b);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView bookTitleText;
        TextView bookAuthorText;
        TextView bookDescription;
        TextView bookCategory;
        TextView bookPrice;
        private Books book;


        public ViewHolder(@NonNull View itemView, Integer studentId) {
            super(itemView);

            // subscribe to click events for this view that holds a book
            itemView.setOnClickListener(this);

            // upon creating, capture all views
            bookTitleText = itemView.findViewById(R.id.bookTitleText);
            bookAuthorText = itemView.findViewById(R.id.bookAuthorText);
            bookDescription = itemView.findViewById(R.id.bookDescription);
            bookCategory = itemView.findViewById(R.id.bookCategory);
        }

        public void setBook(Books book) {
            this.book = book;

            // once a book is attached, assign all fields
            bookTitleText.setText("Title: " + book.getName());
            bookAuthorText.setText("Author: " + book.getAuthor());
            bookCategory.setText("Genre: " + book.getGenre());
            bookPrice.setText("Price: " + book.getCost());
        }
        @Override
        public void onClick(View v) {

        }
    }
}
