package Factory;

import Classes.*;
import State.Account;

import java.util.Date;

public class AccountReport implements Report {
    private int reportId;
    private String type;
    private String content;
    private Date date;
    private Account account;

    public AccountReport( Account account) {
        this.reportId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.date = new Date();
        this.type = "Account";
        this.account = account;

        this.generateReport();
    }


    @Override
    public void generateReport() {
        this.content = "********* "
                + this.type
                + " *********\n"
                + "Account Id : " + this.account.getAccountId() + "\n"
                + "Balance : " + this.account.getTotalBalance() + "\n"
                + "Account state : " + this.account.getState().getType() + "\n"
                + "Debit Limit : " + this.account.getDebit().getLimit() + "\n"
                + "Debit Amount : " + this.account.getDebit().getAmount() + "\n"
                + "Loan : " + this.account.isActiveLoan() + "\n";

        if (this.account.getCard() != null) {
            this.content += "********* CARD *********\n"
                    + "Number : " + this.account.getCard().getCardNumber() + "\n"
                    + "CVC : " + this.account.getCard().getCvc() + "\n"
                    + "EXP : " + this.account.getCard().getExpireDate() + "\n"
                    + "*************** \n";
        }

        if (this.account.isDebit()) {
            this.content += "********* DEBIT *********\n"
                    + "Limit : " + this.account.getDebit().getLimit() + "\n"
                    + "Balance : " + this.account.getDebit().getAmount() + "\n";
        }

        if (this.account.isActiveLoan()) {
            this.content += "********* LOAN ********* \n"
                    + "Loan Id : " + this.account.getLoan().getLoanId() + "\n"
                    + "Total Amount : " + this.account.getLoan().getAmount() + "\n"
                    + "Due Date : " + this.account.getLoan().getDueDate() + "\n"
                    + "Monthly Payment : " + this.account.getLoan().getMonthlyPayment() + "\n"
                    + "Interest Rate : " + this.account.getState().getInterestRate() + "\n"
                    + "Remaining Amount : " + this.account.getLoan().getRemainingAmount() + "\n";
        }

        if (this.account.getTransactions().size()>0) {
            this.content += "********* TRANSACTION ********* \n";
            for (Transaction t :
                    this.account.getTransactions()) {
                this.content += "Transaction Id : " + t.getTransactionId() + "\n"
                                + "Transaction Type : " + t.getTransactionType() + "\n"
                                + "Amount : " + t.getAmount() + "\n"
                                + "Date : " + t.getDate() + "\n"
                                + "Status : " + (t.isStatus() ? "Success" : "Failed") + "\n"
                                + "********" + "\n";
            }

        }
        this.content+= "********************************** \n";
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
