import Classes.Account;
import Classes.Bank;
import Factory.AccountReport;
import Factory.BankReport;
import Factory.ReportFactory;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(1000);
        account.makeLoan(500, new Date("Feb 28 2023"));
        account.withdraw(300);

        ReportFactory rf = new ReportFactory();

        System.out.println(rf.getReport("Account",account));

        Bank bank = new Bank("BNP");

        bank.addCustomer("hassan","0613172014","hassan@gmail.com");

        System.out.println(rf.getReport("Bank",bank));
    }
}
