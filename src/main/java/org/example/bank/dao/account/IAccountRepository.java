package org.example.bank.dao.account;

import org.example.bank.entities.Account;

import java.util.List;
import java.util.Map;

public interface IAccountRepository {
    void createAccount(int id);
    Map<Integer,Account> showAllUserAccounts(int id);
    Account showAccountsByUserId(int id);

}
