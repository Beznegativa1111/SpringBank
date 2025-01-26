package org.example.bank.operations.processors.user;

import org.example.bank.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class GetUserById implements CommonProccessOperationForUsers {

    private UserService userService;
    private Scanner scanner;
    @Autowired
    public GetUserById( UserService userService) {
        this.scanner = new Scanner(System.in);

        this.userService = userService;
    }

    @Override
    public void proccesOperationForUser() {
        System.out.println("Enter user_id: ");
        int id =  scanner.nextInt();
        System.out.println("User with the entered id: \n " +
                userService.getUserById(id) );
    }
}
