package org.example.bank.dao;

import org.example.bank.operations.commands.UserCommands;
import org.example.bank.operations.processors.user.CommonProccessOperationForUsers;
import org.example.bank.operations.processors.user.CreateUser;
import org.example.bank.operations.processors.user.GetUserById;
import org.example.bank.operations.processors.user.ShowAllUsers;
import org.example.bank.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Map;
@Component
public class UserCommandsRepository {
    private final UserService userService;
    private final Map<UserCommands, CommonProccessOperationForUsers>
            userCommands;

    @Autowired
    public  UserCommandsRepository(Map<UserCommands,CommonProccessOperationForUsers> userCommands, UserService userService, CreateUser createUser){
        this.userCommands = userCommands;
        this.userService = userService;
    }

    public void setUserCommands(){
        userCommands.put(UserCommands.USER_CREATE,
               new CreateUser(userService));
        userCommands.put(UserCommands.GET_USER_BY_ID,
                new GetUserById(userService));
        userCommands.put(UserCommands.SHOW_ALL_USERS,
                new ShowAllUsers(userService));
    }

    public void getUserCommands(UserCommands userCommandsUser){
        CommonProccessOperationForUsers common = userCommands.get(userCommandsUser);

         common.proccesOperationForUser();
    }
}
