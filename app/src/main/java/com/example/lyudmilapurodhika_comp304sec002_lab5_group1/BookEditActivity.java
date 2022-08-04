package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BookEditActivity extends AppCompatActivity {
    private EditText bookTitleTextView;
    private EditText bookAuthorTextView;
    private EditText bookCategoryTextView;
    private EditText bookCostTextView;
    private Button bookSaveButton;
    private Button bookDeleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_edit);

        // get references to all views
        bookTitleTextView = findViewById(R.id.editBookTitle);
        bookAuthorTextView = findViewById(R.id.editBookAuthor);
        bookCategoryTextView = findViewById(R.id.editBookGenre);
        bookCostTextView = findViewById(R.id.editBookCost);
    }

    public void saveBook(View view) {
    }

    public void deleteBook(View view) {

    }
}