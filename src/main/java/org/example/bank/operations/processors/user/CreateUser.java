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
        String user_name;
        System.out.println("имя не должно состоять лишь из цифр");
        do {
            System.out.println("Enter desired  user_name");
            user_name = scanner.nextLine();
        } while (user_name.matches("\\d+") || user_name.isEmpty());
        userService.createUser(user_name);
        System.out.println("успешно");
    }
}
