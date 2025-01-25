package org.example.bank.Repositories.Users;

import org.example.bank.Entities.User;

import java.util.Map;

public interface IUserRepositoy {

    public Map<Integer, User> getAllUsers();

    public User getUserById(int userId);

    public void createUser(String user_name);
}
