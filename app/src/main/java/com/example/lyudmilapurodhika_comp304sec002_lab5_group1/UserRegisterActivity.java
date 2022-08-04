package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class UserRegisterActivity extends AppCompatActivity {
BooksViewModel booksViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        booksViewModel = ViewModelProviders.of(this).get(BooksViewModel.class);
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void signUp(View view) {
        EditText etEmail = findViewById(R.id.enterEmailID);
        EditText etpwd = findViewById(R.id.enterNewPaswrd);
        String email = etEmail.getText().toString();
        String password = etpwd.getText().toString();
        booksViewModel.signUp(email, password);

        booksViewModel.getSignUpResult().observe( this, new Observer<Boolean>(){
            @Override
            public void onChanged(@Nullable Boolean result){
                if(result)
                {
                    Toast.makeText(UserRegisterActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UserRegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(UserRegisterActivity.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}



