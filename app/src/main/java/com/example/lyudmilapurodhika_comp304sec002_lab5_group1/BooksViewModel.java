package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;

import android.app.Application;
import android.os.Bundle;

    public class BooksViewModel extends AndroidViewModel {
        private BooksRepository booksRepository;

        public BooksViewModel(@NonNull Application application) {
            super(application);
            booksRepository = new BooksRepository(application);
        }

        public void insert(Books books){
            booksRepository.insert(books);
        }
}