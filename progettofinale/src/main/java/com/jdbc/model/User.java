package com.jdbc.model;

import java.util.Scanner;

import com.jdbc.dbservice.UserDao;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private double balance;

    public User(int id, String username, String password, String email, double balance){
        this.id =id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void versamento(){
        Scanner in = new Scanner(System.in);
        System.out.println("\nQuanto vuoi depositare?");
        double denaro = in.nextDouble();
        this.balance += denaro;
        UserDao userDao = new UserDao();
        userDao.setBalance(this);
        in.close();
    }

    
}
