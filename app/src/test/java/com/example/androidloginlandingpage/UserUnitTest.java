package com.example.androidloginlandingpage;

import com.example.androidloginlandingpage.Model.User;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserUnitTest {
    ArrayList<User> users = MainActivity.setUpUsers();
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void verifyUserNames() {
        assertEquals(users.get(0).getUsername(), "din_djarin");
        assertEquals(users.get(1).getUsername(), "denize");
        assertEquals(users.get(2).getUsername(), "patric");
    }

    @Test
    public void verifyIncorrectUserNames() {
        assertNotEquals(users.get(0).getUsername(), "djarin");
        assertNotEquals(users.get(1).getUsername(), "spongebob");
        assertNotEquals(users.get(2).getUsername(), "patricStar");
    }

    @Test
    public void verifyPasswords() {
        assertEquals(users.get(0).getPassword(), "baby_yoda_ftw");
        assertEquals(users.get(1).getPassword(), "123");
        assertEquals(users.get(2).getPassword(), "456");
    }

    @Test
    public void verifyIncorrectPasswords() {
        assertNotEquals(users.get(0).getPassword(), "baby_yoda");
        assertNotEquals(users.get(1).getPassword(), "456");
        assertNotEquals(users.get(2).getPassword(), "123");
    }

}