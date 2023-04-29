import java.util.Random;

public class Customer {
    private int customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private Account account;

    public Customer(String name, String phoneNumber, String email) {
        this.customerId = (int)Math.floor(Math.random() * 10 + 1);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

        this.account = this.createAccount(new Random().nextInt(999999999 +  1));
    }

    public Account createAccount(float totalBalance){
        this.account = new Account();
        this.account.setTotalBalance(totalBalance);
        return this.account;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", account=" + account +
                '}';
    }
}
