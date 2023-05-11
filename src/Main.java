import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(1000);
//        account.makeLoan(500, new Date("Feb 28 2023"));
        account.withdraw(300);

        AccountReport ac = new AccountReport(account);

        ac.generateReport();

        System.out.println(ac);

        Bank bank = new Bank("BNP");

        bank.addCustomer("hassan","0613172014","hassan@gmail.com");

        BankReport br = new BankReport(bank);

        System.out.println(br);
    }
}
