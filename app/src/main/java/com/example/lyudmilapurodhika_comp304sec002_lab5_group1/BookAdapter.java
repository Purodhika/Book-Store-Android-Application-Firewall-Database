package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{
    private LayoutInflater layoutInflater;
    private Application application;
    private List<Books> books;
    Context context;




    public BookAdapter(bookWorkActivity context, List<Books> books, Application application)
    {
        this.context = context;
        this.books = books;
        this.layoutInflater = LayoutInflater.from(context);
        this.application = application;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create new view/viewholder to present a single book
        View newView = layoutInflater.inflate(R.layout.onebook, parent, false);
        return new ViewHolder(newView, application);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView bookTitleText;
        TextView bookAuthorText;
        TextView bookCategory;
        TextView bookPrice;
        Button button;
        private Books book;
        BooksViewModel viewModel;


        public ViewHolder(@NonNull View itemView, Application application) {
            super(itemView);

            viewModel = new BooksViewModel(application);

            // upon creating, capture all views
            bookTitleText = itemView.findViewById(R.id.bookTitleText);
            bookAuthorText = itemView.findViewById(R.id.bookAuthorText);
            bookCategory = itemView.findViewById(R.id.bookCategory);
            bookPrice = itemView.findViewById(R.id.bookPrice);
            button = itemView.findViewById(R.id.deleteBookButton);

            // deleting a book
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewModel.delete(book);
                }
            });

        }

        public void setBook(Books book) {
            this.book = book;

            // once a book is attached, assign all fields
            bookTitleText.setText("Title: " + book.getName());
            bookAuthorText.setText("Author: " + book.getAuthor());
            bookCategory.setText("Genre: " + book.getGenre());
            bookPrice.setText("Price: " + book.getCost());
        }
    }
}
