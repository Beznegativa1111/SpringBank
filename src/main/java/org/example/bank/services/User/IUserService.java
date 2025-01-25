package org.example.bank.services.User;

import org.example.bank.Entities.User;

import java.util.Map;

public interface IUserService {

     Map<Integer, User> getAllUsers();

     User getUserById(int userId);

    void createUser(String user_name);
}
