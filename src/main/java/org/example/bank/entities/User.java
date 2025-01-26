package org.example.bank.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class User {

    private final String user_name;
    private final List<Account> accounts;

    public User( String user_name, List<Account> accounts) {
        this.accounts = accounts;
        this.user_name = user_name;
    }


    @Override
    public String toString() {
        return "User{" +
                "accounts=" + accounts +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
