package org.example.bank.services.User;

import org.example.bank.entities.User;
import org.example.bank.dao.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
