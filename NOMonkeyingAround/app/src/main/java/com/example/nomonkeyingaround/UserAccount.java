package com.example.nomonkeyingaround;

//Class created to store user account data
public class UserAccount {

    private String name;
    private String userName;
    private int age;
    private String passwd;
    private boolean isTeacher;
    private boolean isStudent;

    //default constructor
    public UserAccount() {
    }

    //parameterized constructor
    public UserAccount(String name, String userName, int age, String passwd, boolean isTeacher, boolean isStudent) {
        this.name = name;
        this.userName = userName;
        this.age = age;
        this.passwd = passwd;
        this.isTeacher = isTeacher;
        this.isStudent = isStudent;
    }

    //Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    //Getter methods
    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getPasswd() {
        return passwd;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public boolean isStudent() {
        return isStudent;
    }

    //overridden toString method
    @Override
    public String toString() {
        return "UserAccount{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", passwd='" + passwd + '\'' +
                ", isTeacher=" + isTeacher +
                ", isStudent=" + isStudent +
                '}';
    }
}
