package org.example.bank.dao.user;

import org.example.bank.entities.Account;
import org.example.bank.entities.User;

import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

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
        if(userRep.get(userId) == null){
            System.out.println("такого юзера не найдено");
            return null;
        }else{
            return userRep.get(userId);
        }
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
    public void setMoneyAmountToUserAccount(int idUser,int idAccount,int money){
        userRep.values().stream().filter(s->s.getId() == idUser)
                .forEach(f->f.getAccounts().stream().filter(g->
                        g.getId() == idAccount).forEach(h->
                        h.setMoneyAmount(money)));

    }

    @Override
    public void transferMoneyToUserAccount(int idUser, int FromAcc, int ToAcc) {
        Optional<User> user =
                userRep.values().stream().filter(s->s.getId() == idUser).findFirst();
        if(user.isPresent()){
            User user1 = user.get();

            Optional<Account> accountFrom =
                    user1.getAccounts().stream().filter(s->s.getId() == FromAcc)
                            .findFirst();
            Optional<Account> accountTo =
                    user1.getAccounts().stream().filter(s->s.getId() == ToAcc)
                            .findFirst();
            if(accountFrom.isPresent() && accountTo.isPresent()){
                Account account = accountFrom.get();
                Account account1 = accountTo.get();

                account1.setMoneyAmount(account.getMoneyAmount() + account1.getMoneyAmount());
                account.setMoneyAmount(account.getMoneyAmount() - account1.getMoneyAmount());
            }

        }



    }
}