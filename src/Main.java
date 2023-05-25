import Classes.Account;
import Observer.TransactionStatusMessageSender;
import Observer.TransactionStatusObserver;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        TransactionStatusObserver messageSender = new TransactionStatusMessageSender();
        account.registerObserver(messageSender);

        account.deposit(1000);
        account.withdraw(10000);

    }
}