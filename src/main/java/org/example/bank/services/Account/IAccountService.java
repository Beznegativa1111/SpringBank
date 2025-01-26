package org.example.bank.services.Account;

import org.example.bank.entities.Account;

import java.util.Map;

public interface IAccountService {
    void createAccount(int id);
    Map<Integer, Account> showAllUserAccounts(int id);
    Account showAccountsByUserId(int id);
}
