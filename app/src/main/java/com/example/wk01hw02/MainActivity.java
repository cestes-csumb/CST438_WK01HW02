/*
Title: MainActivity.java
Purpose: This will serve as the page to list the posts based on the userId. User will need to login first.
 */
package com.example.wk01hw02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.provider.FontsContractCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button loginButton;
    TextView username;
    TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = findViewById(R.id.editTextTextPersonName);
                password = findViewById(R.id.editTextTextPassword);
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();
                //toaster(enteredUsername);
                if(enteredUsername.equals("admin")){
                    if (enteredPassword.equals("test")) {
                        //use intent factory...
                    }else{
                        //toast "incorrect password!"
                        toaster("Incorrect Password!");
                        password.requestFocus();
                    }
                }else{
                    //toast "incorrect username!"
                    toaster("Incorrect Username!");
                    username.requestFocus();
                }

            }
        });
    };
    //generate toast messages
    private void toaster(String message){
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
}