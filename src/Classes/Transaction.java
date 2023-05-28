package Classes;

import java.util.Date;

public class Transaction {
    private int transactionId;
    private String transactionType;
    private Date date;
    private float amount;
    private boolean status;
    private String issue = null;

    public Transaction( String transactionType, Date date, float amount,boolean status) {
        this.transactionId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.transactionType = transactionType;
        this.date = date;
        this.amount = amount;
        this.status = status;
    }

    public Transaction( String transactionType, Date date, float amount,boolean status, String issue) {
        this.transactionId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.transactionType = transactionType;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.issue = issue;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
