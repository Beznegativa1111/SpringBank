package org.example.bank.dao.user;

import org.example.bank.entities.Account;
import org.example.bank.entities.User;

import java.util.Map;

public interface IUserRepositoy {

     Map<Integer, User> getAllUsers();

     User getUserById(int userId);

     void createUser(String user_name);

     void addAccountToUser(Account account, int id);

     void setMoneyAmountToUserAccount(int idUser,int idAccount,int money);

     void transferMoneyToUserAccount(int idUser, int FromAcc, int ToAcc);
}
