package org.example.bank.Repositories.Users;

import org.example.bank.Entities.User;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Component
public class UserRepository implements IUserRepositoy {

    private final Map<Integer, User> userRep;
    private int IDCounter;


    public UserRepository(){
        this.userRep = new HashMap<>();
        IDCounter = 0;
    }
    public Map<Integer,User> getAllUsers(){
        return userRep;
    }

    public User getUserById(int userId){
        return userRep.get(userId);
    }

    public void createUser(String user_name){
        IDCounter++;
        User user = new User(IDCounter,user_name,new ArrayList<>());
        userRep.put(IDCounter,user);
    }
}
