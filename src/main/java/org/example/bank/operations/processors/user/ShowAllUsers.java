package org.example.bank.operations.processors.user;

import org.example.bank.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowAllUsers implements CommonProccessOperationForUsers {

    private UserService userService;


    @Autowired
    public ShowAllUsers( UserService userService) {
        this.userService = userService;
    }

    @Override
    public void proccesOperationForUser() {
        System.out.println("All users: \n " +
                userService.getAllUsers());
    }
}
