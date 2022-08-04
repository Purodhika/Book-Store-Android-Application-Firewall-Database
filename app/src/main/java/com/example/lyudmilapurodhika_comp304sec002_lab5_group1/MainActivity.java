package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity extends AppCompatActivity {
BooksViewModel booksViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance("https://lyudmilapurodhika-304-002-lab5-default-rtdb.firebaseio.com/");
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
        //booksViewModel = new BooksViewModel(getApplication());
        //Books b = new Books("The Secret","Rhonda Byrne","Motivational", 20);
       // Books book2 = new Books("Secons Book", "John Smith", "Documentary", 15);
       // Books book3 = new Books("Third Book", "Mary Johnson", "History", 12);
       // booksViewModel.insert(b);
       // booksViewModel.insert(book2);
        //booksViewModel.insert(book3);
        //Listening Code
    }

    public void goToWorkActivity(View view) {
        // open book Work activity
        Context ctx = view.getContext();
        Intent intent = new Intent(ctx, bookWorkActivity.class);
        ctx.startActivity(intent);
    }
}
