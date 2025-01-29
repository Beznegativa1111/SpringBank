package org.example.bank.operations.processors.account;

import org.example.bank.services.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class TransferMoneyToUserAccount implements CommonProcessOperationsForAccounts{
    private AccountService accountService;
    private Scanner scanner;

    @Autowired
    public TransferMoneyToUserAccount(AccountService accountService){
        this.accountService = accountService;
        scanner = new Scanner(System.in);
    }


    @Override
    public void processOperationForAccount() {
        System.out.println("выберите юзера");
        int idUser = scanner.nextInt();
        System.out.println("с какого аккаунта вы хотите перевести деньги");
        int FromAcc = scanner.nextInt();
        System.out.println("на какой аккаунт вы хотите перевести деньги");
        int ToAcc = scanner.nextInt();
        accountService.transferMoneyToUserAccount(idUser,FromAcc,ToAcc);

    }
}
