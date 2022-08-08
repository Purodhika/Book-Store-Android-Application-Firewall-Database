package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class bookWorkActivity extends AppCompatActivity {
    RecyclerView booksRV;
    BooksViewModel viewModel;
    BookAdapter adapter;
    List<Books> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_work);

        // prep recyclerview
        booksRV = findViewById(R.id.booksRV);

        // init array
        books = new ArrayList<>();

        // pass books into the recycler view
        booksRV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BookAdapter(this,  books, getApplication());
        booksRV.setAdapter(adapter);


        //fetch data
        viewModel = new BooksViewModel(getApplication());
        DatabaseReference ref = viewModel.getAllBooks();


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //
                books.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Books book = dataSnapshot.getValue(Books.class);
                    books.add(book);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public void addNewBook(View view) {
        // open new activity
        Context ctx = view.getContext();
        Intent intent = new Intent(ctx, BookAddActivity.class);
        ctx.startActivity(intent);
    }

}