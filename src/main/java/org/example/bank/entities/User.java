package org.example.bank.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class User {
    private final int id;
    private final String user_name;
    private  List<Account> accounts;

    public User(int id,String user_name,List<Account> accounts) {
        this.id = id;
        this.accounts = accounts;
        this.user_name = user_name;
    }


    @Override
    public String toString() {
        return "User{" +
                "accounts=" + accounts +
                ", id=" + id +
                ", user_name='" + user_name + '\'' +
                '}';
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }
}
