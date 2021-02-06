/*
Title: MainActivity.java
Purpose: This will serve as the page to list the posts based on the userId. User will need to login first.
Note: Some code reused from my old Software Design final project
 */
package com.example.wk01hw02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //layout elements
    Button loginButton;
    TextView username;
    TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = findViewById(R.id.button);
        //If user clicks on login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = findViewById(R.id.editTextTextPersonName);
                password = findViewById(R.id.editTextTextPassword);
                //Store strings user entered
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();
                //Get default logins
                Users userslist = new Users();
                ArrayList<String> usernames = userslist.getUsernames();
                ArrayList<String> passwords = userslist.getPasswords();
                //Check if username is within logins
                if(usernames.contains(enteredUsername)){
                    //figure out the userId
                    int userId = usernames.indexOf(enteredUsername);
                    //Check if password matches
                    if (passwords.get(userId).equals(enteredPassword)) {
                        //use intent factory...
                        toaster("Login Successful");
                        //Not sure if I'm using this as intended
                        //Need to look into the factory pattern
                        IntentFactory intentFactory = new IntentFactory() {
                            @Override
                            public Intent GenerateIntent() {
                                Intent intent = new Intent(MainActivity.this, DisplayPosts.class);
                                return intent;
                            }
                        };
                        //Generate intent
                        Intent intent = intentFactory.GenerateIntent();
                        //Store extras (userId and username)
                        intent.putExtra("USER_ID", userId+1);
                        intent.putExtra("USERNAME", enteredUsername);
                        startActivity(intent);
                    //Toasts for incorrect password
                    }else{
                        //toast "incorrect password!"
                        toaster("Incorrect Password!");
                        //change focus
                        password.requestFocus();
                    }
                    //and incorrect username
                }else{
                    //toast "incorrect username!"
                    toaster("Incorrect Username!");
                    //change focus
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