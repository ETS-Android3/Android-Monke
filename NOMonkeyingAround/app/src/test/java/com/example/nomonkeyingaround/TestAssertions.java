package com.example.nomonkeyingaround;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(TestRunner.class)
public class TestAssertions {
    UserAccountTest Test = new UserAccountTest();
    UserAccount exampleAccount = new UserAccount("Declan", "brinnerdt", 21, "brinnerdt@gmail.com", "1234", false, true, false);

        public boolean passwdIsLongEnough(UserAccount ua){
        String x = ua.getPasswd();
        if (x.length() < 8){
            return false;
        }
        else{
            return true;
        }
    }
    @Test
    public void passwdLen() {
        assertEquals(true, passwdIsLongEnough(exampleAccount));
    }
}