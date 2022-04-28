package com.example.nomonkeyingaround;

public class ClinicalAccount extends UserAccount{
    public ClinicalAccount() {
    }

    public ClinicalAccount(String name, String userName, int age, String email, String passwd, boolean isTeacher, boolean isStudent, boolean isPhysician) {
        super(name, userName, age, passwd, email, isTeacher, isStudent, isPhysician);
    }
}
