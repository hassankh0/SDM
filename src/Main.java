import Bankfacade.BankFacade;
import Classes.Account;
import Classes.Bank;
import Factory.ReportFactory;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Account account2 = new Account();
        Bank bank = new Bank("BNP");
        ReportFactory rf = new ReportFactory();
        BankFacade bankFacade = new BankFacade(account, bank, rf);
        
        bankFacade.deposit(1000);
        bankFacade.withdraw(300);
        bankFacade.transfer(500, account2);
        
        bankFacade.makeLoan(500, new Date("Feb 28 2023"));

        System.out.println(bankFacade.getAccountReport(account));

        bankFacade.addCustomer("hassan", "0613172014", "hassan@gmail.com");

        System.out.println(bankFacade.getBankReport(bank));
    }
}
