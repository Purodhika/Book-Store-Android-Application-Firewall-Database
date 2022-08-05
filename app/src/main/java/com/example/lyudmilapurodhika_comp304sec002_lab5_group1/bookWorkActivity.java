package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class bookWorkActivity extends AppCompatActivity {
    RecyclerView booksRV;
    BooksViewModel viewModel;
    BookAdapter booksAdapter;
    List<Books> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_work);

        //testing data
        list.add(new Books("A","A", "A", 20));
        list.add(new Books("B","B", "B", 10));
        list.add(new Books("C","C", "C", 40));
        list.add(new Books("D","D", "D", 24));
        list.add(new Books("E","E", "E", 50));
        // prep recyclerview
        booksRV = findViewById(R.id.booksRV);
        booksRV.setLayoutManager(new LinearLayoutManager(this));

        //fetch data
        viewModel = new BooksViewModel(getApplication());

        // pass selected songs into the recycler view
        //rv.setLayoutManager(new LinearLayoutManager(this));
       // adapter = new MyRVAdapter(this,  selectedSongs);
       // rv.setAdapter(adapter);

    }
    //activity to display all books
    //on click on recycler view an Edit book Activity will open
    //where we can delete or edit a book
    //on add book button an activity will open to add a new book

    public void addNewBook(View view) {
        // open new activity
        Context ctx = view.getContext();
        Intent intent = new Intent(ctx, BookAddActivity.class);
        ctx.startActivity(intent);
    }
}