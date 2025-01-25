package org.example.bank;


import org.example.bank.Scanners.ScannerLines;
import org.example.bank.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import static org.example.bank.Commands.*;

@Component
public class OperationsListener {
    private ScannerLines scanner;
    private UserService userService;

    @Autowired
    public OperationsListener(UserService userService, ScannerLines scanner){
        this.scanner = scanner;
        this.userService = userService;
    }

    public void sendOperationsForUser(){
        while(true){
            String user = null;
            System.out.println("Enter command: ");
            String command = scanner.getScanner();

            if(command.equals(USER_CREATE.name())){
                System.out.println("Enter desired name");
                user  = scanner.getScanner();
                userService.createUser(user);
            }
            else if(command.equals(SHOW_ALL_USERS.name())){
                    System.out.println("All Users: ");
                    System.out.println(userService.getAllUsers());

                }
            else if(command.equals(GET_BY_ID.name())) {
                System.out.println("Enter id");
                user = scanner.getScanner();
                System.out.println(userService.getUserById(Integer.parseInt(user)));
            }
        }
    }

}
