package Factory;

import Classes.*;

import java.util.Date;
import java.util.Iterator;

public class AccountReport implements Report {
    private int reportId;
    private String type;
    private String content;
    private Date date;
    private Account account;

    public AccountReport( Account account) {
        this.reportId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.date = new Date();
        this.type = "Classes.Account Factory.Report";
        this.account = account;

        this.generateReport();
    }


    @Override
    public void generateReport() {
        this.content = "********* "
                + this.type
                + " *********\n"
                + "Classes.Account Id : " + this.account.getAccountId() + "\n"
                + "Balance : " + this.account.getTotalBalance() + "\n"
                + "Classes.Debit : " + this.account.getDebit() + "\n"
                + "Classes.Loan : " + this.account.isActiveLoan() + "\n";

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
                    + "Classes.Loan Id : " + this.account.getLoan().getLoanId() + "\n"
                    + "Total Amount : " + this.account.getLoan().getAmount() + "\n"
                    + "Due Date : " + this.account.getLoan().getDueDate() + "\n"
                    + "Monthly Payment : " + this.account.getLoan().getMonthlyPayment() + "\n"
                    + "Classes.Interest Rate : " + this.account.getInterestRate() + "\n"
                    + "Remaining Amount : " + this.account.getLoan().getRemainingAmount() + "\n";
        }

        if (this.account.getTransactions().size()>0) {
            this.content += "********* TRANSACTION ********* \n";
            for (Transaction t :
                    this.account.getTransactions()) {
                this.content += "Classes.Transaction Id : " + t.getTransactionId() + "\n"
                                + "Classes.Transaction Type : " + t.getTransactionType() + "\n"
                                + "Amount : " + t.getAmount() + "\n"
                                + "Date : " + t.getDate() + "\n"
                                + "Status : " + (t.isStatus() ? "Success" : "Failed") + "\n";
            }

        }
        this.content+= "********************************** \n";
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
    public String toString() {
        return this.content;
    }
}
