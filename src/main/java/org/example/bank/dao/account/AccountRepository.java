package org.example.bank.dao.account;
import org.example.bank.dao.user.UserRepository;
import org.example.bank.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;

import java.util.Map;


@Component
public class AccountRepository implements IAccountRepository{
        private static Map<Integer,Account> accountRepository;
        private UserRepository userRepository;
        private int IDCounterOfAccount;


        @Autowired
        public AccountRepository(UserRepository userRepository){
                this.userRepository = userRepository;
                accountRepository = new HashMap<>();
                IDCounterOfAccount = 0;
        }


        @Override
        public void createAccount(int id) {
                IDCounterOfAccount++;
                Account account = new Account( IDCounterOfAccount ,id,0);
                userRepository.addAccountToUser(account,id);
                accountRepository.put(IDCounterOfAccount,account);


        }

        @Override
        public  Map<Integer,Account> showAllUserAccountsByUserId(int IDCounterOfUser) {
                Map<Integer, Account> accounts = new HashMap<>();
                accountRepository.values().stream()
                        .filter(s->s.getUserId() == IDCounterOfUser)
                        .forEach(f->accounts.put(f.getId(),f));
                return accounts;
        }

        @Override
        public void putMoneyIntoUser(int idUser,int idAccount,int money) {
                accountRepository.values()
                        .stream().filter(s->s.getId() == idAccount)
                        .forEach(f->f.setMoneyAmount(money));
                userRepository.setMoneyAmountToUserAccount(idUser,idAccount,money);


        }


}