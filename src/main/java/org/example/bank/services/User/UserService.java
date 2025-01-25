package org.example.bank.services.User;

import org.example.bank.Entities.User;
import org.example.bank.Repositories.Users.IUserRepositoy;
import org.example.bank.Repositories.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(String  user_name){
        userRepository.createUser(user_name);
    }
    public User getUserById(int userId){
        return userRepository.getUserById(userId);
    }
    public Map<Integer,User> getAllUsers(){
        return userRepository.getAllUsers();

    }
}
