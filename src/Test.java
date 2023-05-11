import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class Test {

    // Account

    @org.junit.jupiter.api.Test
    public void testDeposit() {
        Account account = new Account();
        assertEquals(0, account.getTotalBalance());

        float depositedAmount = 1000;
        account.deposit(depositedAmount);
        assertEquals(depositedAmount, account.getTotalBalance());
    }

    @org.junit.jupiter.api.Test
    public void testWithdraw() {
        Account account = new Account();
        float initialBalance = 1000;
        account.setTotalBalance(initialBalance);

        // Withdraw more than the current balance
        assertFalse(account.withdraw(initialBalance + 1));
        assertEquals(initialBalance, account.getTotalBalance());

        // Withdraw less than the current balance
        float withdrawnAmount = 500;
        assertTrue(account.withdraw(withdrawnAmount));
        assertEquals(initialBalance - withdrawnAmount, account.getTotalBalance());
    }

    @org.junit.jupiter.api.Test
    public void testTransfer() {
        Account account1 = new Account();
        Account account2 = new Account();
        float initialBalance = 1000;
        account1.setTotalBalance(initialBalance);

        // Transfer more than the current balance
        assertFalse(account1.transfer(initialBalance + 1, account2));
        assertEquals(initialBalance, account1.getTotalBalance());
        assertEquals(0, account2.getTotalBalance());

        // Transfer less than the current balance
        float transferredAmount = 500;
        assertTrue(account1.transfer(transferredAmount, account2));
        assertEquals(initialBalance - transferredAmount, account1.getTotalBalance());
        assertEquals(transferredAmount, account2.getTotalBalance());
    }

    @org.junit.jupiter.api.Test
    public void testMakeLoan() {
        Account account = new Account();
        assertFalse(account.isActiveLoan());

        float loanAmount = 1000;
        assertTrue(account.makeLoan(loanAmount,new Date()));
        assertTrue(account.isActiveLoan());
    }

    // Bank

    @org.junit.jupiter.api.Test
    public void testAddCustomer() {
        Bank bank = new Bank("My Bank");
        Customer customer = bank.addCustomer("John Doe", "123-456-7890", "johndoe@email.com");
        assertEquals(1, bank.getCustomers().size());
        assertTrue(bank.getCustomers().contains(customer));
    }

    // Customer

    @org.junit.jupiter.api.Test
    public void testCreateAccount() {
        Customer customer = new Customer("John Smith", "123-456-7890", "john.smith@email.com");
        Account account = customer.createAccount(1000.0f);

        assertNotNull(account); // Test that a new Account object is created
        assertEquals(1000.0f, account.getTotalBalance(), 0.0f); // Test that the initial balance is set correctly
    }

    // Interest

    @org.junit.jupiter.api.Test
    public void testCalculate() {
        // Test case 1
        Interest interest1 = new Interest(10000, 12, 0.06f);
        float expected1 = 860.66f;
        float actual1 = interest1.calculate();
        assertEquals(expected1, actual1, 0.01f);

        // Test case 2
        Interest interest2 = new Interest(5000, 6, 0.05f);
        float expected2 = 845.51f;
        float actual2 = interest2.calculate();
        assertEquals(expected2, actual2, 0.01f);

        // Test case 3
        Interest interest3 = new Interest(20000, 24, 0.08f);
        float expected3 = 904.54f;
        float actual3 = interest3.calculate();
        assertEquals(expected3, actual3, 0.01f);
    }

}
