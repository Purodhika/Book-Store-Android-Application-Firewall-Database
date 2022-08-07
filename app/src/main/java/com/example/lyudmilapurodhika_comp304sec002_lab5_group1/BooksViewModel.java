package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import android.app.Application;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;

public class BooksViewModel extends AndroidViewModel {
        //private static BooksViewModel booksRepository;
        //private static LiveData<T> signup;
        private BooksRepository booksRepository;
        private LiveData<Boolean> signup;

        public BooksViewModel(@NonNull Application application) {
            super(application);
            booksRepository = new BooksRepository(application);
            signup = booksRepository.getSignUpResult();
        }

        public void signUp(String email, String password) { booksRepository.signUp(email, password);}


        public LiveData<Boolean> getSignUpResult() { return signup;}


        public void insert(Books books){
            booksRepository.insert(books);
        }

        public DatabaseReference getAllBooks(){
            DatabaseReference ref  =  booksRepository.getAllBooks();
            return ref;
        }

        public void delete(Books book){booksRepository.delete(book);}

}