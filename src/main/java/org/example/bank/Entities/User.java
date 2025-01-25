package org.example.bank.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class User {
    private final int id;
    private final String user_name;
    private final List<Account> accounts;

    public User( int id,String user_name, List<Account> accounts) {
        this.accounts = accounts;
        this.id = id;
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
}
