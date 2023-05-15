package Factory;

import java.util.Date;
import java.util.Iterator;
import Classes.*;

public class BankReport implements Report {
    private int reportId;
    private String type;
    private String content;
    private Date date;
    private Bank bank;

    public BankReport(Bank bank) {
        this.reportId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.content = "";
        this.date = new Date();
        this.type = "Bank";
        this.bank = bank;

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
                + "Bank Id : " + this.bank.getBankId() + "\n"
                + "Bank Name : " + this.bank.getName() + "\n"
                + "Total Customers : " + this.bank.getCustomers().size() + "\n"
                + "********* Customers *********\n";

        for(Iterator var1 = this.bank.getCustomers().iterator(); var1.hasNext(); this.content += "************************* \n") {
            Customer customer = (Customer) var1.next();
            this.content += "Customer Id : " + customer.getCustomerId() + "\n"
                    + "Name: " + customer.getName() + "\n"
                    + "Email : " + customer.getEmail() + "\n"
                    + "Phone Number : " + customer.getPhoneNumber() + "\n"
                    + customer.getAccount() + "\n";
        }
    }

    @Override
    public String toString() {
        return this.content;
    }
}
