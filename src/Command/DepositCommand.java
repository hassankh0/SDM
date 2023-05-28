package Command;

import Classes.Account;
import Classes.Transaction;

import java.util.Date;

public class DepositCommand implements BankCommand {
    private Account account;
    private float amount;

    public DepositCommand(Account account, float amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        boolean status = account.deposit(amount);
        System.out.println("Deposit of " + amount + " to account " + account.getAccountId() + " executed.");
        Transaction transaction = new Transaction("Deposit",new Date(),amount,status);
        account.addTransactions(transaction);

    }
}
