package com.example.lyudmilapurodhika_comp304sec002_lab5_group1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class MainActivity extends AppCompatActivity {
    BooksViewModel booksViewModel;
    EditText username;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.enterUserID);
        password = findViewById(R.id.enterUserPaswrd);

        booksViewModel = new BooksViewModel(getApplication());
    }

    public void goToWorkActivity(View view) {
        String u = username.getText().toString();
        String p = password.getText().toString();

        booksViewModel.signIn(u, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    // open book Work activity
                    Context ctx = view.getContext();
                    Intent intent = new Intent(ctx, bookWorkActivity.class);
                    ctx.startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Email or password is invalid!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void goToRegisterActivity(View view) {
        Intent intent = new Intent(this, UserRegisterActivity.class);
        startActivity(intent);
    }
}
