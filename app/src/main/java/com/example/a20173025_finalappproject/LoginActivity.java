package com.example.a20173025_finalappproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class LoginActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;

    TextInputEditText usernameInput;
    TextInputEditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameInput = (TextInputEditText) findViewById(R.id.usernameInput);
        passwordInput = (TextInputEditText) findViewById(R.id.passwordInput);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginProcess(v);
            }
        });



    }

    public void loginProcess (View v){
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();
        if(username.equals("it") && password.equals("0000")) {
            Intent intent = new Intent(getApplicationContext(), bar.class);
            intent.putExtra("username", username);
            intent.putExtra("password", password);
            startActivityForResult(intent, REQUEST_CODE_MENU);
            Toast.makeText(this,username + "님, 환영합니다!",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "로그인 정보가 없습니다", Toast.LENGTH_LONG).show();
            passwordInput.setText("");
        }
    }

}