package com.example.wk01hw02;

import java.util.ArrayList;

public class Users {
    //ArrayLists for usernames and passwords
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    Users(){
        //Default User Logins (5 total)
        usernames.add("admin");
        passwords.add("password");
        usernames.add("admin2");
        passwords.add("test");
        usernames.add("chris");
        passwords.add("chris");
        usernames.add("din_djarin");
        passwords.add("baby_yoda_ftw");
        usernames.add("test");
        passwords.add("test");
    }

    //Getters

    public ArrayList<String> getUsernames() {
        return usernames;
    }

    public ArrayList<String> getPasswords() {
        return passwords;
    }
}
