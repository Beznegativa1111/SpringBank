package org.example.bank.dao.user;

import lombok.Setter;
import org.example.bank.dao.account.AccountRepository;
import org.example.bank.entities.Account;
import org.example.bank.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class UserRepository implements IUserRepositoy {

    private final Map<Integer, User> userRep;
    private static int IDCounterOfUser;


    public UserRepository() {
        this.userRep = new HashMap<>();
        IDCounterOfUser = 0;
    }



    public Map<Integer, User> getAllUsers() {
        return userRep;
    }

    public User getUserById(int userId) {
        return userRep.get(userId);
    }

    public void createUser(String user_name) {
        IDCounterOfUser++;
        User user = new User(IDCounterOfUser, user_name, new ArrayList<>());
        userRep.put(IDCounterOfUser, user);

    }

    public void addAccountToUser(Account account, int id) {
        Account accounts =  new Account(account.getId(), account.getUserId(), account.getMoneyAmount());
        userRep.values().stream().filter(s->
                s.getId() == accounts.getUserId())
                    .forEach(f->f.getAccounts().add(accounts));

    }
}