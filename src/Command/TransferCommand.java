package Command;

import Classes.Account;
import Classes.Transaction;

import java.util.Date;

public class TransferCommand implements BankCommand {
    private Account sourceAccount;
    private Account targetAccount;
    private float amount;

    public TransferCommand(Account sourceAccount, Account targetAccount, float amount) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        boolean status = false;
        System.out.println(
                "Transfer of " + amount + " from account " + sourceAccount.getAccountId() +
                        " to account " + targetAccount.getAccountId() + " executed."
        );

        if (sourceAccount.withdraw(amount)) {
            status = targetAccount.deposit(amount);
        }

        Transaction transaction = new Transaction("Transfer",new Date(),amount,status);
        sourceAccount.addTransactions(transaction);

    }
}