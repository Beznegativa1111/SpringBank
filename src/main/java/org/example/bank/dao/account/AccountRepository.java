package org.example.bank.dao.account;
import org.example.bank.dao.user.UserRepository;
import org.example.bank.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;

import java.util.Map;
import java.util.Optional;


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
        public void putMoneyIntoUserAccount(int idUser, int idAccount, int money) {
                Optional<Account> account =  accountRepository.values()
                        .stream().filter(s->
                                s.getId() == idAccount).findFirst();
                if(account.isEmpty()){
                        System.out.println("не найден аккаунт");
                }else {
                        account.stream().forEach(s->s.setMoneyAmount(money));
                        userRepository.setMoneyAmountToUserAccount(idUser,idAccount,money);

                }




        }

        @Override
        public void transferMoneyToUserAccount(int idUser, int FromAcc, int ToAcc) {
                Account accountFrom =  accountRepository.get(FromAcc);
                Account accountTo = accountRepository.get(ToAcc);
                accountTo.setMoneyAmount(accountTo.getMoneyAmount() +
                        accountTo.getMoneyAmount());
                userRepository.transferMoneyToUserAccount(idUser,FromAcc,ToAcc);
        }


}