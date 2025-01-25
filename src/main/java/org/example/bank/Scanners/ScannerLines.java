package org.example.bank.Scanners;

import org.springframework.stereotype.Component;


import java.util.Scanner;
@Component
public class ScannerLines {

    public String getScanner(){
        return new Scanner(System.in).nextLine();
    }
}
