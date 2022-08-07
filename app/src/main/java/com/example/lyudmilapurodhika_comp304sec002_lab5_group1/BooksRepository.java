package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;

public class BooksRepository
{

        private final BooksDao booksDao;

    public LiveData<Boolean> signup;

    public BooksRepository(Context context) {
            booksDao = BooksDao.getInstance();
            signup = booksDao.getSignUpResult();
        }

        public void insert(Books book){
            booksDao.insert(book);
        }
       // public DatabaseReference getBook(Books book) {booksDao.get(book);}
        public DatabaseReference getAllBooks (){
            DatabaseReference ref = booksDao.getAllBooks();
            return ref;
         }
        public void delete(Books book){booksDao.delete(book);};


    public void signUp(String email, String password) { booksDao.signUp(email, password);}

    public Task<AuthResult> signIn(String username, String password) {
            return booksDao.signIn(username, password);
    }

    public LiveData<Boolean> getSignUpResult() { return signup;}

}