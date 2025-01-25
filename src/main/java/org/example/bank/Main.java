package org.example.bank;

import org.example.bank.config.ConfigApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ConfigApplication.class);
        context.getBean(OperationsListener.class).sendOperationsForUser();
    }
}
