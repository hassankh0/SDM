package Factory;

import Classes.Bank;
import Classes.Customer;
import Classes.Account;

public class ReportFactory {

    public Report getReport(String reportType, Bank bank) {

        if (reportType.equalsIgnoreCase("Bank")) {
            return new BankReport(bank);
        }

        return null;
    }

    public Report getReport(String reportType, Customer customer) {

        if (reportType.equalsIgnoreCase("Customer")) {
            return new CustomerReport(customer);
        }

        return null;
    }

    public Report getReport(String reportType, Account account) {
        if (reportType.equalsIgnoreCase("Account")) {
            return new AccountReport(account);

        }
        return null;
    }

}

