package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public class BooksRepository
{

        private final BooksDao booksDao;

        public BooksRepository(Context context) {
            booksDao = BooksDao.getInstance();
        }

        public void insert(Books book){
            booksDao.insert(book);
        }
        public void getBook(Books book) {booksDao.get(book);}
        public void getAllBooks (){booksDao.getAllBooks();}
        public void delete(Books book){booksDao.delete(book);};


}