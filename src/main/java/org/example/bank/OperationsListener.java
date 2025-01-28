package org.example.bank;


import org.example.bank.dao.AccountCommandsRepository;
import org.example.bank.dao.UserCommandsRepository;
import org.example.bank.operations.commands.AccountCommands;
import org.example.bank.operations.commands.UserCommands;
import org.example.bank.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import java.util.Scanner;


@Component
public class OperationsListener {
    private final UserService userService;
    private final Scanner scanner;
    private final UserCommandsRepository userCommandsRepository;
    private final AccountCommandsRepository accountCommandsRepository;

    @Autowired
    public OperationsListener(
            UserService userService, UserCommandsRepository userCommandsRepository, AccountCommandsRepository accountCommandsRepository){
        this.userService = userService;
        this.userCommandsRepository = userCommandsRepository;
        this.accountCommandsRepository = accountCommandsRepository;
        scanner = new Scanner(System.in);
        userCommandsRepository.setUserCommands();
        accountCommandsRepository.setAccountsCommands();
        sendOperationsForUser();
    }


    public void sendOperationsForUser(){
        while (true) {
            System.out.println("Enter desired command");
            String command  = scanner.nextLine();
            try{
                UserCommands userCommands = UserCommands.valueOf(command.toUpperCase());
                userCommandsRepository.getUserCommands(userCommands);
            }catch ( IllegalArgumentException  e){
                try{
                    AccountCommands accountCommands = AccountCommands.valueOf(command.toUpperCase());
                    accountCommandsRepository.getAccountCommands(accountCommands);
                }catch (IllegalArgumentException e2){
                    System.out.println("не удалось");
                }
            }
        }
    }
}
