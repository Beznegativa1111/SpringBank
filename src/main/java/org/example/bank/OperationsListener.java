package org.example.bank;


import org.example.bank.operations.commands.AccountCommands;
import org.example.bank.operations.commands.UserCommands;
import org.example.bank.operations.processors.account.CreateAccountForUser;
import org.example.bank.operations.processors.account.GetAllUserAccountsByIid;
import org.example.bank.operations.processors.account.ShowAllUserAccounts;
import org.example.bank.operations.processors.user.CreateUser;
import org.example.bank.operations.processors.user.GetUserById;
import org.example.bank.operations.processors.user.ShowAllUsers;
import org.example.bank.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class OperationsListener {
    private final UserService userService;
    private CreateUser createUser;
    private GetUserById getUserById;
    private ShowAllUsers showAllUsers;
    private Scanner scanner;
    private CreateAccountForUser createAccountForUser;
    private GetAllUserAccountsByIid getAllUserAccountsByIid;
    private ShowAllUserAccounts showAllUserAccounts;


    @Autowired
    public OperationsListener(UserService userService,CreateUser createUser
    ,GetUserById getUserById ,ShowAllUsers showAllUsers
    ,CreateAccountForUser createAccountForUser,GetAllUserAccountsByIid getAllUserAccountsByIid
    , ShowAllUserAccounts showAllUserAccounts){
        this.userService = userService;
        this.getUserById = getUserById;
        this.showAllUsers = showAllUsers;
        this.createUser = createUser;
        this.createAccountForUser = createAccountForUser;
        this.getAllUserAccountsByIid = getAllUserAccountsByIid;
        this.showAllUserAccounts = showAllUserAccounts;
        scanner = new Scanner(System.in);
        sendOperationsForUser();
    }


    public void sendOperationsForUser(){
        while (true) {
            System.out.println("Enter desired command");
            String command = scanner.nextLine();

            if(command.equals(UserCommands.USER_CREATE.name())){
                createUser.proccesOperationForUser();
            }
            else if(command.equals(UserCommands.SHOW_ALL_USERS.name())){
                showAllUsers.proccesOperationForUser();
            }
            else if(command.equals(UserCommands.GET_USER_BY_ID.name())){
                getUserById.proccesOperationForUser();
            }
            else if(command.equals(AccountCommands.ACCOUNT_CREATE.name())){
                createAccountForUser.processOperationForAccount();
            }
            else if(command.equals(AccountCommands.SHOW_ACCOUNTS_BY_USERID.name())){
                getAllUserAccountsByIid.processOperationForAccount();
            }
            else if(command.equals(AccountCommands.SHOW_ALL_ACCOUNTS.name())){
                showAllUserAccounts.processOperationForAccount();
            }
        }


    }

}
