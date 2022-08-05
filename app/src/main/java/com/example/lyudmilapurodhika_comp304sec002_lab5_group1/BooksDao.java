package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
            private FirebaseAuth mAuth;
    MutableLiveData<Boolean> flag = new MutableLiveData<>();
    private LiveData<Boolean> signup;

    //Singleton Pattern to have one instance of DB

            private BooksDao(){
                database = FirebaseDatabase.getInstance("https://lyudmilapurodhika-304-002-lab5-default-rtdb.firebaseio.com/");
                myRef = database.getReference(DATABASE_NAME);
                mAuth = FirebaseAuth.getInstance();
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
            //public  void get(Books book){}

            //getting all books
            public DatabaseReference getAllBooks(){
                return myRef;

            }

            //deleting a book
            public void delete(Books book){
                myRef.push().setValue(null);
            }

    public void signUp(String email, String password) 
    {
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    
                    Log.d(TAG, "createuser:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    Log.d(TAG,"Current user " +user.getEmail());
                    signUpSuccess(true);
                }
                else
                {
                    Log.w(TAG, "Signup failed", task.getException());
                    signUpSuccess(false);
                }
            }
        });

    }

    private void signUpSuccess(boolean signup) {flag.postValue(signup);
    }

    public LiveData<Boolean> getSignUpResult() {return flag;}}


