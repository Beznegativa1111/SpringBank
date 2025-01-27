package org.example.bank;

import org.example.bank.config.ConfigApplication;
import org.example.bank.operations.commands.UserCommands;
import org.example.bank.operations.processors.user.CommonProccessOperationForUsers;
import org.example.bank.operations.processors.user.CreateUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static CreateUser createUser;
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ConfigApplication.class);



    }

}
