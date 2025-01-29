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
        System.out.println("все должно вводится в виде чисел");
        int idUser;
        int idAccount;
        int sum;

            System.out.println("на какого юзера вы хотели бы положить деньги");
            idUser = scanner.nextInt();
            System.out.println("введите айди аккаунта");
             idAccount = scanner.nextInt();
            System.out.println("введите сумму");
             sum = scanner.nextInt();

        accountService.putMoneyIntoUserAccount(idUser, idAccount, sum);
    }
}
