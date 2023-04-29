import java.util.Date;

public class CustomerReport implements Report{
    private int reportId;
    private String type;
    private String content;
    private Date date;
    private Customer customer;

    public CustomerReport( Customer customer) {
        this.reportId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.date = new Date();
        this.type = "Customer Report";
        this.customer = customer;

        this.generateReport();
    }

    @Override
    public void generateReport() {
        this.content = "********* "
                + this.type
                + " *********\n"
                + "Customer Id : " + this.customer.getCustomerId() + "\n"
                + "Customer Name : " + this.customer.getName() + "\n"
                + "Customer Email : " + this.customer.getEmail() + "\n"
                + "Customer Phone Number : " + this.customer.getPhoneNumber() + "\n"
                + "Account Id : " + this.customer.getAccount().getAccountId() + "\n"
                + "Account Balance : " + this.customer.getAccount().getTotalBalance() + "\n"
                + "Account Interest Rate : " + this.customer.getAccount().getInterestRate() + "\n"
                + "*********************";
    }
}
