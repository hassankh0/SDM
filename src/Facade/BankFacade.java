package Facade;
import Classes.Account;
import Classes.Bank;
import Classes.Customer;
import Command.DepositCommand;
import Command.LoanCommand;
import Command.TransferCommand;
import Command.WithdrawCommand;
import Factory.ReportFactory;
import Factory.Report;

import java.util.Date;

public class BankFacade {
    private Account account;
    private Bank bank;
    private ReportFactory reportFactory;

    public BankFacade(Account account, Bank bank, ReportFactory reportFactory) {
        this.account = account;
        this.bank = bank;
        this.reportFactory = reportFactory;
    }

    public void deposit(float amount) {
        DepositCommand depositCommand = new DepositCommand(this.account,amount);
        depositCommand.execute();
    }

    public void withdraw(float amount) {
        WithdrawCommand withdrawCommand = new WithdrawCommand(this.account,amount);
        withdrawCommand.execute();
    }

    public void transfer(float amount, Account destinationAccount) {
        TransferCommand transferCommand = new TransferCommand(this.account,destinationAccount,amount);
        transferCommand.execute();
    }

    public void makeLoan(float amount, Date dueDate) {
        LoanCommand loanCommand = new LoanCommand(account,amount,dueDate);
        loanCommand.execute();

    }

    public void getAccountReport(Account account) {
        Report accountReport = reportFactory.getReport("Account", account);
        if (accountReport != null) {
            System.out.println(accountReport.getContent());
        }
        System.out.println("Account Report not Found");
    }

    public void getBankReport(Bank bank) {
        Report bankReport = reportFactory.getReport("Bank", bank);
        if (bankReport != null) {
            System.out.println(bankReport.getContent());
        }
        System.out.println("Bank Report not Found");
    }

    public Customer addCustomer(String name, String phoneNumber, String email) {
        Customer customer = bank.addCustomer(name, phoneNumber, email);
        if (customer != null) {
            customer.createAccount(0.0f);
        }
        return customer;
    }
}
