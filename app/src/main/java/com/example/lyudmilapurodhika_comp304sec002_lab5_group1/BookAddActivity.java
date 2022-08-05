package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BookAddActivity extends AppCompatActivity {
    private EditText bookTitleTextView;
    private EditText bookAuthorTextView;
    private EditText bookCategoryTextView;
    private EditText bookCostTextView;
    BooksViewModel booksViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_add);
        // get references to all views
        bookTitleTextView = findViewById(R.id.editBookTitle);
        bookAuthorTextView = findViewById(R.id.editBookAuthor);
        bookCategoryTextView = findViewById(R.id.editBookGenre);
        bookCostTextView = findViewById(R.id.editBookCost);
    }

    public void addNewBook(View view) {
        booksViewModel = new BooksViewModel(getApplication());
          Books b = new Books(
         bookTitleTextView.getText().toString(),
         bookAuthorTextView.getText().toString(),
         bookCategoryTextView.getText().toString(),
         Integer.parseInt(bookCostTextView.getText().toString())
         );
        booksViewModel.insert(b);
    }
}