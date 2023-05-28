import Facade.BankFacade;
import Classes.Account;
import Classes.Bank;
import Classes.Customer;
import Factory.ReportFactory;
import Observer.TransactionStatusMessageSender;
import Observer.TransactionStatusObserver;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
      
        TransactionStatusObserver messageSender = new TransactionStatusMessageSender();
        account.registerObserver(messageSender);
      
        Account account2 = new Account();
      
        TransactionStatusObserver messageSender2 = new TransactionStatusMessageSender();
        account2.registerObserver(messageSender2);
      
        Bank bank = new Bank("BNP");
        ReportFactory rf = new ReportFactory();
        BankFacade bankFacade = new BankFacade(account, bank, rf);
        
        bankFacade.deposit(1000);
        bankFacade.withdraw(300);
        bankFacade.transfer(800, account2);
        
        bankFacade.makeLoan(500, new Date("DEC 28 2023"));

        bankFacade.getAccountReport(account);

        Customer customer = bankFacade.addCustomer("hassan", "0613172014", "hassan@gmail.com");

        bankFacade.getBankReport(bank);

//        System

    }
}