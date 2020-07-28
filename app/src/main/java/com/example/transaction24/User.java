package com.example.transaction24;

public class User {
    public String name, email, phone,password;
    public int balance;

    public User(){

    }

    public User(String name, String email, String phone,String password,int balance) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password=password;
        this.balance=balance;
    }
}
