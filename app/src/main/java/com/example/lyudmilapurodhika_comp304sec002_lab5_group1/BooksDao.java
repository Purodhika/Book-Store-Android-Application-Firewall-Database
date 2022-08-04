package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class BooksDao {

            private static volatile BooksDao INSTANCE;
            private static final String DATABASE_NAME = "BooksDB";
            FirebaseDatabase database;
            DatabaseReference myRef;

            //Singleton Pattern to have one instance of DB

            private BooksDao(){
                database = FirebaseDatabase.getInstance("https://lyudmilapurodhika-304-002-lab5-default-rtdb.firebaseio.com/");
                myRef = database.getReference(DATABASE_NAME);
            }

            public static BooksDao getInstance(){
                if (INSTANCE == null) {
                    //Create database object
                    INSTANCE = new BooksDao();
                }
                return INSTANCE;
            }

            //insert one book
            public void insert(Books book){
                myRef.push().setValue(book);
            }

            //getting one book
            public  void get(Books book){

            }

            //getting all books
            public void getAllBooks(){
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            //deleting a book
            public void delete(Books book){
                myRef.push().setValue(null);
            }

        }

