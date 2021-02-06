package com.example.wk01hw02;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void check_login_one(){
        Users testUsers = new Users();
        ArrayList<String> usernames = testUsers.getUsernames();
        ArrayList<String> passwords = testUsers.getPasswords();
        assertEquals(true, usernames.get(0).contains("admin"));
        int userId = usernames.indexOf("admin");
        assertEquals(true, passwords.get(userId).equals("password"));
    }
    @Test
    public void check_login_five(){
        Users testUsers = new Users();
        ArrayList<String> usernames = testUsers.getUsernames();
        ArrayList<String> passwords = testUsers.getPasswords();
        assertEquals(true, usernames.get(4).equals("test"));
        int userId = usernames.indexOf("test");
        assertEquals(true, passwords.get(userId).equals("test"));
    }
    @Test
    public void check_invalid_username(){
        Users testUsers = new Users();
        ArrayList<String> usernames = testUsers.getUsernames();
        ArrayList<String> passwords = testUsers.getPasswords();
        assertNotEquals(true, usernames.contains("chris_redfield"));
    }
    @Test
    public void check_invalid_password(){
        Users testUsers = new Users();
        ArrayList<String> usernames = testUsers.getUsernames();
        ArrayList<String> passwords = testUsers.getPasswords();
        assertEquals(true, usernames.contains("din_djarin"));
        int userId = usernames.indexOf("din_djarin");
        assertNotEquals(true, passwords.get(userId).equals("test"));
    }
}