package org.example.bank.services.Account;

import org.example.bank.dao.account.AccountRepository;
import org.example.bank.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service

public class AccountService implements IAccountService {

    private AccountRepository accountRepository;


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

}
