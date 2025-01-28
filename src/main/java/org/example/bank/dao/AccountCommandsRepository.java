package org.example.bank.dao;

import org.example.bank.operations.commands.AccountCommands;
import org.example.bank.operations.processors.account.CommonProcessOperationsForAccounts;
import org.example.bank.operations.processors.account.CreateAccountForUser;
import org.example.bank.operations.processors.account.ShowAllUserAccounts;
import org.example.bank.operations.processors.account.PutMoneyIntoUser;
import org.example.bank.services.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class AccountCommandsRepository {

    private final AccountService accountService;
    private final Map<AccountCommands, CommonProcessOperationsForAccounts>
                accountsCommands;

    @Autowired
    public AccountCommandsRepository(Map<AccountCommands, CommonProcessOperationsForAccounts>
                                             accountsCommands, AccountService accountService){
        this.accountService = accountService;
        this.accountsCommands = accountsCommands;
    }
    public void setAccountsCommands(){
        accountsCommands.put(AccountCommands.ACCOUNT_CREATE,
                new CreateAccountForUser(accountService));

        accountsCommands.put(AccountCommands.SHOW_ALL_USER_ACCOUNTS,
                new ShowAllUserAccounts(accountService));

        accountsCommands.put(AccountCommands.PUT_MONEY_ON_USER,
                new PutMoneyIntoUser(accountService));
    }

    public void getAccountCommands(AccountCommands accountCommand){
        CommonProcessOperationsForAccounts common =
                accountsCommands.get(accountCommand);

        common.processOperationForAccount();

    }
}
