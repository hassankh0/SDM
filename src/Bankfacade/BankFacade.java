package Bankfacade;
import Classes.Account;
import Classes.Bank;
import Classes.Customer;
import Factory.ReportFactory;
import Factory.Report;

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
        account.deposit(amount);
    }

    public void withdraw(float amount) {
        account.withdraw(amount);
    }

    public void transfer(float amount, Account destinationAccount) {
        if (account.withdraw(amount)) {
            destinationAccount.deposit(amount);
            System.out.println("Transfer of " + amount + " from account " + account.getAccountId()
                    + " to account " + destinationAccount.getAccountId() + " successful.");
        } else {
            System.out.println("Transfer failed due to insufficient funds.");
        }
    }

    public boolean makeLoan(float amount, java.util.Date dueDate) {
        return account.makeLoan(amount, dueDate);
    }

    public String getAccountReport(Account account) {
        Report accountReport = reportFactory.getReport("Account", account);
        if (accountReport != null) {
            return accountReport.getContent();
        }
        return null;
    }

    public String getBankReport(Bank bank) {
        Report bankReport = reportFactory.getReport("Bank", bank);
        if (bankReport != null) {
            return bankReport.getContent();
        }
        return null;
    }

    public Customer addCustomer(String name, String phoneNumber, String email) {
        Customer customer = bank.addCustomer(name, phoneNumber, email);
        if (customer != null) {
            customer.createAccount(0.0f);
        }
        return customer;
    }
}
