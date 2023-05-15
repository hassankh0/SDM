package Command;

import Classes.Account;

public class WithdrawCommand implements BankCommand {
    private Account account;
    private float amount;

    public WithdrawCommand(Account account, float amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);

        System.out.println("Withdrawal of " + amount + " from account " + account.getAccountId() + " executed.");
    }
}
