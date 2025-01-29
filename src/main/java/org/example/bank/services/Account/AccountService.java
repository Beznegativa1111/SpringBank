package org.example.bank.services.Account;

import org.example.bank.dao.account.AccountRepository;
import org.example.bank.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service

public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;


    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(int id) {

        accountRepository.createAccount(id);
    }

    @Override
    public Map<Integer, Account> showAllUserAccounts(int id) {
        return accountRepository.showAllUserAccountsByUserId(id);
    }

    @Override
    public void putMoneyIntoUserAccount(int idUser, int idAccount, int sum) {
        accountRepository.putMoneyIntoUserAccount(idUser,idAccount, sum);
    }

    @Override
    public void transferMoneyToUserAccount(int idUser, int FromAcc, int ToAcc) {
        accountRepository.transferMoneyToUserAccount(idUser,FromAcc,ToAcc);
    }


}
