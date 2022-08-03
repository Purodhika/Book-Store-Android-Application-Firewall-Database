package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

            public void insert(Books book){
                myRef.push().setValue(book);
            }

        }

