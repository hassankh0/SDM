package Factory;

import Singelton.Bank;
import Classes.Customer;
import State.Account;

public class ReportFactory {

    public Report getReport(Bank bank) {

        return bank == null ? null : new BankReport(bank);
    }

    public Report getReport(Customer customer) {

        return customer == null ? null : new CustomerReport(customer);
    }

    public Report getReport(Account account) {

        return account == null ? null : new AccountReport(account);
    }

}

