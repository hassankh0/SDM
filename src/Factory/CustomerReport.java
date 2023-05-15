package Factory;
import Classes.Customer;

import java.util.Date;

public class CustomerReport implements Report {
    private int reportId;
    private String type;
    private String content;
    private Date date;
    private Customer customer;

    public CustomerReport( Customer customer) {
        this.reportId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.date = new Date();
        this.type = "Customer";
        this.customer = customer;

        this.generateReport();
    }

    @Override
    public int getReportId() {
        return this.reportId;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public Date getReportDate() {
        return this.date;
    }

    @Override
    public void generateReport() {
        this.content = "********* "
                + this.type
                + " *********\n"
                + "Classes.Customer Id : " + this.customer.getCustomerId() + "\n"
                + "Classes.Customer Name : " + this.customer.getName() + "\n"
                + "Classes.Customer Email : " + this.customer.getEmail() + "\n"
                + "Classes.Customer Phone Number : " + this.customer.getPhoneNumber() + "\n"
                + "Classes.Account Id : " + this.customer.getAccount().getAccountId() + "\n"
                + "Classes.Account Balance : " + this.customer.getAccount().getTotalBalance() + "\n"
                + "Classes.Account Classes.Interest Rate : " + this.customer.getAccount().getInterestRate() + "\n"
                + "*********************";
    }
}
