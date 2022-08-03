package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

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
        booksViewModel = ViewModelProviders.of(this).get(BooksViewModel.class);
        Books b = new Books("The Secret","Rhonda Byrne","Motivational", 20);
        booksViewModel.insert(b);


        //Listening Code

    }

}
