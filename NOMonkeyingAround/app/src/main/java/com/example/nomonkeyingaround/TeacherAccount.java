package com.example.nomonkeyingaround;

public class TeacherAccount extends UserAccount {
    public TeacherAccount() {
    }

    public TeacherAccount(int id, String name, String userName, int age, String passwd, boolean isTeacher, boolean isStudent, boolean isPhysician) {
        super(id, name, userName, age, passwd, isTeacher, isStudent, isPhysician);
    }
}
