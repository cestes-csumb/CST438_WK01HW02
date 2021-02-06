package com.example.wk01hw02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Users {
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    Users(){
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

    public ArrayList<String> getUsernames() {
        return usernames;
    }

    public ArrayList<String> getPasswords() {
        return passwords;
    }
}
