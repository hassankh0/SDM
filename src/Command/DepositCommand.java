package Command;

import Classes.Account;

public class DepositCommand implements BankCommand {
    private Account account;
    private float amount;

    public DepositCommand(Account account, float amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);

        System.out.println("Deposit of " + amount + " to account " + account.getAccountId() + " executed.");
    }
}
