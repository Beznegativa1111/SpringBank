package org.example.bank.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {

    private final int userId;

    private int moneyAmount;

    public Account( int userId, int moneyAmount) {
        this.userId = userId;
        this.moneyAmount = moneyAmount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "moneyAmount=" + moneyAmount +
                ", userId=" + userId +
                '}';
    }
}
