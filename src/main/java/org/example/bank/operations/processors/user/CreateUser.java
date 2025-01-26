package org.example.bank.operations.processors.user;

import org.example.bank.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateUser implements CommonProccessOperationForUsers {

    private UserService userService;

    private Scanner scanner;
    @Autowired
    public CreateUser( UserService userService) {
        this.scanner = new Scanner(System.in);
        this.userService = userService;
    }

    @Override
    public  void proccesOperationForUser() {
        System.out.println("Enter desired  user_name");
        String user_name = scanner.nextLine();
        userService.createUser(user_name);
        System.out.println("Successful creating user");

    }
}
