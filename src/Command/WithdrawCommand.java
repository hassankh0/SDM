package Command;

import Classes.Account;
import Classes.Transaction;

import java.util.Date;

public class WithdrawCommand implements BankCommand {
    private Account account;
    private float amount;

    public WithdrawCommand(Account account, float amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        boolean status = account.withdraw(amount);

        System.out.println("Withdrawal of " + amount + " from account " + account.getAccountId() + " executed.");

        Transaction transaction = new Transaction("Withdraw",new Date(),amount,status);
        account.addTransactions(transaction);
    }
}
