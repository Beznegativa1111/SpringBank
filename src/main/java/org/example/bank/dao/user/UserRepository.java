package org.example.bank.dao.user;

import org.example.bank.dao.account.AccountRepository;
import org.example.bank.entities.Account;
import org.example.bank.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Component
public class UserRepository implements IUserRepositoy {

    private final Map<Integer, User> userRep;
    private AccountRepository accountRepository;
    private static int IDCounterOfUser;

    @Autowired
    public UserRepository(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
        this.userRep = new HashMap<>();
        IDCounterOfUser = 0;
    }
    public Map<Integer,User> getAllUsers(){
        return userRep;
    }

    public User getUserById(int userId){
        return userRep.get(userId);
    }

    public void createUser(String user_name){
        IDCounterOfUser++;
        User user = new User(user_name,
                accountRepository.showAllUserAccounts(IDCounterOfUser)
                        .values().stream().toList());

        userRep.put(IDCounterOfUser,user);
    }
}
