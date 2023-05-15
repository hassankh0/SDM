package Command;

import Classes.Account;

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
        if (sourceAccount.withdraw(amount)) {
            targetAccount.deposit(amount);
        }

        System.out.println(
                "Transfer of " + amount + " from account " + sourceAccount.getAccountId() +
                        " to account " + targetAccount.getAccountId() + " executed."
        );
    }
}