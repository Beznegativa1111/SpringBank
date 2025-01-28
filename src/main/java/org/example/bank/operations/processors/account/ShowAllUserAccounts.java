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
        System.out.println("Enter id of User which you want to see accounts");
        int id = scanner.nextInt();
        System.out.println("All Account this user: " +
                accountService.showAllUserAccounts(id));


    }
}
