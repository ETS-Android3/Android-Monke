package com.example.nomonkeyingaround;

public class StudentAccount extends UserAccount{
    public StudentAccount() {
    }

    public StudentAccount(String name, String userName, int age, String email, String passwd, boolean isTeacher, boolean isStudent, boolean isPhysician) {
        super(name, userName, age, email, passwd,isTeacher, isStudent, isPhysician);
    }
}
