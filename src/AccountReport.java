import java.util.Date;
import java.util.Iterator;

public class AccountReport implements Report{
    private int reportId;
    private String type;
    private String content;
    private Date date;
    private Account account;

    public AccountReport( Account account) {
        this.reportId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.date = new Date();
        this.type = "Account Report";
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
                + "Debit : " + this.account.getDebit() + "\n"
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
                    + "Balance : " + this.account.getDebit().getAmount() + "\n"
                    + "**************** \n";
        }

        if (this.account.isActiveLoan()) {
            this.content += "********* LOAN ********* \n"
                    + "Loan Id : " + this.account.getLoan().getLoanId() + "\n"
                    + "Total Amount : " + this.account.getLoan().getAmount() + "\n"
                    + "Due Date : " + this.account.getLoan().getDueDate() + "\n"
                    + "Monthly Payment : " + this.account.getLoan().getMonthlyPayment() + "\n"
                    + "Interest Rate : " + this.account.getInterestRate() + "\n"
                    + "Remaining Amount : " + this.account.getLoan().getRemainingAmount() + "\n"
                    + "*************** \n";
        }

//        this.content = this.content + "***** TRANSACTIONS ***** \n";
//
//        for(Iterator var1 = this.account.getAccountTransactions().iterator(); var1.hasNext(); this.content = this.content + "************************ \n") {
//            Transaction transaction = (Transaction)var1.next();
//            var10001 = this.content;
//            this.content = var10001 + "Type : " + transaction.getType() + "\n";
//            var10001 = this.content;
//            this.content = var10001 + "Amount : " + transaction.getAmount() + "\n";
//            var10001 = this.content;
//            this.content = var10001 + "Status : " + transaction.getStatus() + "\n";
//        }
//
//        this.content = this.content + "************************* \n";
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
