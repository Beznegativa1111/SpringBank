package org.example.bank.entities;

import lombok.Getter;
import lombok.Setter;


public class Account {
    private final int id;
    private final int userId;
    private int moneyAmount;

    public Account( int id, int userId, int moneyAmount) {
        this.id = id;
        this.userId = userId;
        this.moneyAmount = moneyAmount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", moneyAmount=" + moneyAmount +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public int getUserId() {
        return userId;
    }
}
