package Classes;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int bankId;
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.bankId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.name = name;
        this.customers = new ArrayList();
    }

    public Customer addCustomer(String name,String phoneNumber, String email) {
        Customer cust = new Customer(name,phoneNumber,email);
        this.customers.add(cust);
        return cust;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Classes.Bank{" +
                "bankId=" + bankId +
                ", name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
