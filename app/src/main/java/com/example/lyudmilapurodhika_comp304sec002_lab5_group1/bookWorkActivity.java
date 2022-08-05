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
    BookAdapter booksAdapter;
    List<Books> list;

    private DatabaseReference dbReference;
    BookAdapter adapter;
    List<Books> books;

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

        books = new ArrayList<>();
        adapter = new BookAdapter(this, books);
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://lyudmilapurodhika-304-002-lab5-default-rtdb.firebaseio.com/");
        dbReference = db.getReference(Books.class.getSimpleName());

        // prep recyclerview
        booksRV = findViewById(R.id.booksRV);
        booksRV.setHasFixedSize(true);
        booksRV.setLayoutManager(new LinearLayoutManager(this));
        booksRV.setAdapter(adapter);


        //fetch data
        viewModel = new BooksViewModel(getApplication());

        // pass selected songs into the recycler view
        //rv.setLayoutManager(new LinearLayoutManager(this));
       // adapter = new MyRVAdapter(this,  selectedSongs);
       // rv.setAdapter(adapter);

        dbReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


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
}

    //activity to display all books
    //on click on recycler view an Edit book Activity will open
    //where we can delete or edit a book
    //on add book button an activity will open to add a new book

//    public void addNewBook(View view) {
//        // open new activity
//        Context ctx = view.getContext();
//        Intent intent = new Intent(ctx, BookAddActivity.class);
//        ctx.startActivity(intent);
//    }
//}