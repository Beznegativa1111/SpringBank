package org.example.bank.operations.processors.account;

import org.example.bank.services.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ShowAllUserAccounts{

    private AccountService accountService;
    private Scanner scanner;

    @Autowired
    public ShowAllUserAccounts(AccountService accountService){
        this.accountService = accountService;
        scanner = new Scanner(System.in);


    }
    public void processOperationForAccount() {
        System.out.println("введите айди юзера");
        int id = scanner.nextInt();
        System.out.println("All accounts:" +
                accountService.showAllUserAccounts(id));
    }
}
