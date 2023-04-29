public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        AccountReport ac = new AccountReport(account);

        ac.generateReport();

        System.out.println(ac);

        Bank bank = new Bank("BNP");

        bank.addCustomer("hassan","0613172014","hassan@gmail.com");

        BankReport br = new BankReport(bank);

        System.out.println(br);
    }
}
