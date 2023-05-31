package Facade;
import State.Account;
import Command.*;
import Singelton.Bank;
import Classes.Customer;
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
        Command command = new DepositCommand(this.account,amount);
        this.account.doCommand(command);
    }

    public void withdraw(float amount) {
        Command command = new WithdrawCommand(this.account,amount);
        this.account.doCommand(command);
    }

    public void transfer(float amount, Account destinationAccount) {
        Command command = new TransferCommand(this.account,destinationAccount,amount);
        this.account.doCommand(command);
    }

    public void makeLoan(float amount, Date dueDate) {
        Command command = new LoanCommand(account,amount,dueDate);
        this.account.doCommand(command);

    }

    public void getAccountReport(Account account) {
        Report accountReport = reportFactory.getReport(account);
        if (accountReport != null) {
            System.out.println(accountReport.getContent());
        } else {
            System.out.println("Account Report not Found");
        }
    }

    public void getBankReport(Bank bank) {
        Report bankReport = reportFactory.getReport(bank);
        if (bankReport != null) {
            System.out.println(bankReport.getContent());
        } else {
            System.out.println("Bank Report not Found");
        }
    }

    public Customer addCustomer(String name, String phoneNumber, String email) {
        Customer customer = bank.addCustomer(name, phoneNumber, email);
        if (customer != null) {
            customer.createAccount(0.0f);
        }
        return customer;
    }
}
