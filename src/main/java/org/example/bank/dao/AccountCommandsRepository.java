package org.example.bank.dao;

import org.example.bank.operations.commands.AccountCommands;
import org.example.bank.operations.processors.account.CommonProcessOperationsForAccounts;
import org.example.bank.operations.processors.account.CreateAccountForUser;
import org.example.bank.operations.processors.account.GetAllUserAccountsByIid;
import org.example.bank.services.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
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
                new GetAllUserAccountsByIid(accountService));
    }

    public void getAccountCommands(AccountCommands accountCommand){
        CommonProcessOperationsForAccounts common =
                accountsCommands.get(accountCommand);

        common.processOperationForAccount();

    }
}
