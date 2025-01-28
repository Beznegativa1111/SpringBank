package org.example.bank.operations.processors.account;

import org.example.bank.services.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class PutMoneyIntoUser implements CommonProcessOperationsForAccounts {

    private AccountService accountService;
    private Scanner scanner;

    @Autowired
    public PutMoneyIntoUser(AccountService accountService){
        this.accountService = accountService;
        scanner = new Scanner(System.in);
    }


    @Override
    public void processOperationForAccount() {
        System.out.println("на какого юзера вы хотели бы положить деньги");
        int idUser = scanner.nextInt();
        System.out.println("введите айди аккаунта");
        int idAccount = scanner.nextInt();
        System.out.println("введите сумму");
        int sum = scanner.nextInt();
        accountService.putMoneyIntoUser(idUser,idAccount ,sum);
    }
}
