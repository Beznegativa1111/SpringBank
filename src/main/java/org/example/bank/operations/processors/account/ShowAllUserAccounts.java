package org.example.bank.operations.processors.account;

import org.example.bank.services.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;


@Component
public class ShowAllUserAccounts implements CommonProcessOperationsForAccounts{
    private AccountService accountService;
    private Scanner scanner;

    @Autowired
    public ShowAllUserAccounts(AccountService accountService){
        this.accountService = accountService;
        scanner = new Scanner(System.in);
    }


    @Override
    public void processOperationForAccount() {
        System.out.println("айди юзера должен быть и цифр");
        int id;
        do {
            System.out.println("Enter id of User which you want to see accounts");
            id = scanner.nextInt();
        } while (String.valueOf(id).matches("\\d+") || String.valueOf(id).isEmpty());

        System.out.println("All Account this user: " +
                accountService.showAllUserAccounts(id));


    }
}
