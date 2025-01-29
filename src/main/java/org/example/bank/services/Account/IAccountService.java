package org.example.bank.services.Account;

import org.example.bank.entities.Account;

import java.util.Map;

public interface IAccountService {
    void createAccount(int id);

    Map<Integer, Account> showAllUserAccounts(int id);

    void putMoneyIntoUserAccount(int idUser, int idAccount, int sum);

    void transferMoneyToUserAccount(int idUser, int FromAcc, int ToAcc);

}
