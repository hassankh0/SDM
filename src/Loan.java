import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Loan {
    private int loanId;
    private float amount;
    private float monthlyPayment;
    private Date dueDate;
    private Date startDate;
    private float remainingAmount;

    public Loan(float amount, float interestRate, Date dueDate) {
        this.loanId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.startDate = new Date();
        this.amount = amount;
        this.dueDate = dueDate;

        // Convert java.util.Date objects to java.time.LocalDate objects
        LocalDate startLocalDate = this.startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = this.dueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Period period = Period.between(startLocalDate, endLocalDate);
        int numberMonths = period.getYears() * 12 + period.getMonths();

        Interest interest = new Interest(amount, numberMonths, interestRate);
        this.monthlyPayment = interest.calculate();
        this.remainingAmount = amount;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(float monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public float getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(float remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public boolean payLoan(){
        this.remainingAmount -= this.monthlyPayment;
        return true;
    }
}
