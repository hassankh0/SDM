package Command;

import Classes.Account;
import Classes.Transaction;

import java.util.Date;

public class LoanCommand implements BankCommand {
    private Account account;
    private float amount;
    private  Date dueDate;

    public LoanCommand(Account account, float amount, Date dueDate) {
        this.account = account;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    @Override
    public void execute() {
        boolean status = account.makeLoan(amount,dueDate);
        System.out.println("Loan of " + amount + " to account " + account.getAccountId() + " executed.");
        Transaction transaction = new Transaction("Loan",new Date(),amount,status);
        account.addTransactions(transaction);

    }
}
