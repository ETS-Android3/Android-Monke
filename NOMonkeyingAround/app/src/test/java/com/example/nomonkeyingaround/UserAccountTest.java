package com.example.nomonkeyingaround;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserAccountTest {
    @Test
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
    public boolean passwdComplexity(UserAccount ua){
        String x = ua.getPasswd();
        boolean hasCap = false;
        boolean hasSpec = false;
        boolean hasNum = false;
        for (int i = 0; i < x.length(); i++){
            int ascii = x.charAt(i);
            if (ascii < 48){
                hasSpec = true;
            }
            else if (ascii < 58) {
                hasNum = true;
            }
            else if (ascii < 65){
                hasSpec = true;
            }
            else if (ascii < 91){
                hasCap = true;
            }
            else if (ascii < 97){
                hasSpec = true;
            }
            else if (ascii > 122){
                hasSpec = true;
            }
            if (hasSpec && hasNum && hasCap){
                return true;
            }
        }
        return false;
    }

    @Test
    public boolean oldEnough(UserAccount ua){
        int x = ua.getAge();
        if (x < 14){
            return false;
        }
        else{
            return true;
        }
    }

    @Test
    public boolean usernameComplexity(UserAccount ua){
        String x = ua.getUserName();
        for (int i = 0; i < x.length(); i++) {
            int ascii = x.charAt(i);
            if (!((ascii > 48 && ascii < 58) || (ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123))){
                return false;
            }
        }
        return true;
    }

    @Test
    public boolean lettersOnlyName(UserAccount ua){
        String x = ua.getName();
        for (int i = 0; i < x.length(); i++) {
            int ascii = x.charAt(i);
            if (!((ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123))){
                return false;
            }
        }
        return true;
    }

    public boolean emailFormat(UserAccount ua){
        String email = ua.getEmail();

        // email prefix
        int atSign = 0;
        // find end of prefix
        for(int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                atSign = i;
            }
        }
        for(int j = 0; j < atSign; j++){
            // only allow nums, letters, _'s, -'s, and .'s
            // _, -, or . must be followed by a letter
            int ascii = email.charAt(j);
            // check if not num or letter
            if (!((ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123) || (ascii > 48 && ascii < 58))){
                // check if -, _, or .
                if(ascii == 45 || ascii == 46 || ascii == 95){
                    // ensure we're not at the end
                    if(j + 1 < atSign) {
                        int ascii2 = email.charAt(j + 1);
                        // ensure next char is num or letter
                        if (!((ascii2 > 64 && ascii2 < 91) || (ascii2 > 96 && ascii2 < 123) || (ascii2 > 48 && ascii2 < 58))) {
                            // if its not the email is invalid
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                // if its not any accepted, its invalid
                else {
                    return false;
                }
            }
        }

        // domain name
        int dot = 0;
        // find end of domain name
        for(int k = atSign + 1; k < email.length(); k++){
            if (email.charAt(k) == '.'){
                dot = k;
            }
        }
        // domain name must have at least two characters at the end for dot whatever
        // also if dot isn't updated email is invalid
        if(dot == 0 || dot == email.length() - 1 || dot == email.length() - 2){
            return false;
        }
        for(int a = atSign + 1; a < dot; a++){
            // only allow nums, letters, and -'s
            // - must be followed by a letter
            int ascii = email.charAt(a);
            // check if not num or letter
            if (!((ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123) || (ascii > 48 && ascii < 58))){
                if(ascii == 45){
                    // ensure we're not at the end
                    if(a + 1 < dot) {
                        int ascii2 = email.charAt(a + 1);
                        // ensure next char is num or letter
                        if (!((ascii2 > 64 && ascii2 < 91) || (ascii2 > 96 && ascii2 < 123) || (ascii2 > 48 && ascii2 < 58))) {
                            // if its not the domain is invalid
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }

        // end portion
        for(int b = dot; b < email.length(); b++){
            int ascii = email.charAt(b);
            // must be letters
            if(!((ascii > 64 && ascii < 91) || (ascii > 96 && ascii < 123))){
                return false;
            }
        }
        return true;
    }

    public boolean correctParameterTypes(UserAccount ua){
        return false;
    }
}