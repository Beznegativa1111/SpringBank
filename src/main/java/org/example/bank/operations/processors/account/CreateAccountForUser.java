package org.example.bank.operations.processors.account;

import org.example.bank.services.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateAccountForUser implements CommonProcessOperationsForAccounts {
    private AccountService accountService;
    private Scanner scanner;

    @Autowired
    public CreateAccountForUser(AccountService accountService){
        this.accountService =  accountService;
        scanner = new Scanner(System.in);

    }

    @Override
    public void processOperationForAccount() {
        System.out.println("айди должен быть из цифр");
        String id;
        do {
            System.out.println("Enter id of account which you want to create");
            id = scanner.nextLine();
        } while (id.isEmpty() || !id.matches("\\d+"));

        accountService.createAccount(Integer.parseInt(id));
    }



}
