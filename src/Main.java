import Classes.Account;
import Classes.Bank;
import Command.BankCommand;
import Command.DepositCommand;
import Command.TransferCommand;
import Command.WithdrawCommand;
import Factory.AccountReport;
import Factory.BankReport;
import Factory.ReportFactory;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Account account2 = new Account();
        Bank bank = new Bank("BNP");
        ReportFactory rf = new ReportFactory();
        BankCommand depositCommand = new DepositCommand(account, 1000);
        BankCommand withdrawCommand = new WithdrawCommand(account, 300);
        BankCommand transferCommand = new TransferCommand(account, account2, 500);

        depositCommand.execute();
        withdrawCommand.execute();
        transferCommand.execute();

        account.makeLoan(500, new Date("Feb 28 2023"));


        System.out.println(rf.getReport("Account",account));


        bank.addCustomer("hassan","0613172014","hassan@gmail.com");

        System.out.println(rf.getReport("Bank",bank));
    }
}
