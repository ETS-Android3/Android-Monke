package com.example.nomonkeyingaround;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import android.util.Log;

import org.junit.jupiter.api.Test;

public class UserAccountTest {

    UserAccount userAccount;

    @Test
    public void passwdLengthTest() {
        assertFalse(passwdIsLongEnough());
    }
    public boolean passwdIsLongEnough(){
        String x = userAccount.getPasswd();
        if (x.length() < 8){
            return false;
        }
        else{
            return true;
        }
    }
}