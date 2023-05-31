package Singelton;

import Classes.Customer;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static Bank instance;
    private int bankId;
    private String name;
    private List<Customer> customers;

    private Bank(String name) {
        this.bankId = (int) Math.floor(Math.random() * 900000.0 + 100000.0);
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public static Bank getInstance(String name) {
        if (instance == null) {
            instance = new Bank(name);
        }
        return instance;
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
