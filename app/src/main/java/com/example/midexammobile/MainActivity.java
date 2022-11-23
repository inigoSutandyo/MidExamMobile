package com.example.midexammobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText txtEmail, txtPassword;

    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txt_login_email);
        txtPassword = findViewById(R.id.txt_login_password);
        loginBtn = findViewById(R.id.btn_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = txtEmail.getText().toString();
                password = txtPassword.getText().toString();

                if (login(email, password)) {
                    movePage(email);
                }
            }
        });

    }

    private void movePage(String email) {
        finish();
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("EMAIL", email);
        startActivity(intent);

    }

    private boolean login(String email, String password) {

        if (email.equals("test@mail.com") && password.equals("test123")) {
            return true;
        }

      return false;
    };
}