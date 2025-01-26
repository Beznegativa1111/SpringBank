package org.example.bank.dao.account;

import org.example.bank.dao.user.UserRepository;
import org.example.bank.entities.Account;
import org.example.bank.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class AccountRepository implements IAccountRepository{

        private static Map<Integer,Account> accountRepository;
        private int IDCounterOfAccount;

        public AccountRepository(){
                accountRepository = new HashMap<>();
                IDCounterOfAccount = 0;
        }
        @Override
        public void createAccount(int id) {
                IDCounterOfAccount++;
                Account account = new Account(IDCounterOfAccount,0);
                accountRepository.put(IDCounterOfAccount,new Account(id,0));


        }

        @Override
        public  Map<Integer,Account> showAllUserAccounts(int IDCounterOfUser) {
                Map<Integer,Account> accounts = new HashMap<>();
                accountRepository.values()
                        .stream().filter(s->{
                                if(s.getUserId() == IDCounterOfUser){
                                       accounts.put(IDCounterOfAccount
                                       ,s);
                                }
                                return false;
                        });

                return accounts;
        }

        @Override
        public Account showAccountsByUserId(int id) {
                return accountRepository.get(id);
        }
}
