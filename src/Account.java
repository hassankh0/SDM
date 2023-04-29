import java.util.Date;

public class Account {
    private int accountId;
    private float totalBalance;
    private float interestRate;
    private boolean activeLoan;
    private Date dateOpening;
    private boolean isDebit;
    private Card card;
    private Debit debit;
    private Loan loan;


    public Account() {
        this.accountId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.isDebit = false;
        this.activeLoan = false;
        this.dateOpening = new Date();
        this.card = new Card();
        this.debit = new Debit(1000);
        this.loan = new Loan(0,this.interestRate,new Date());
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public float getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(float totalBalance) {
        this.totalBalance = totalBalance;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public boolean isActiveLoan() {
        return activeLoan;
    }

    public void setActiveLoan(boolean activeLoan) {
        this.activeLoan = activeLoan;
    }

    public Date getDateOpening() {
        return dateOpening;
    }

    public void setDateOpening(Date dateOpening) {
        this.dateOpening = dateOpening;
    }

    public boolean isDebit() {
        return isDebit;
    }

    public void setDebit(boolean debit) {
        isDebit = debit;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Debit getDebit() {
        return debit;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public float deposit(float amount) {
        this.totalBalance += amount;
        return this.totalBalance;
    }

    public boolean withdraw(float amount) {
        if (amount > this.totalBalance) {
            if (this.isDebit){
                this.totalBalance -= amount;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            this.totalBalance -= amount;
            return true;
        }
    }

    public boolean transfer(float amount,Account receipientAccount) {
        if(this.withdraw(amount)) {
            receipientAccount.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean makeLoan(float amount) {
        if (this.activeLoan)
            return false;

        //create loan
        this.activeLoan = true;
        return true;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", totalBalance=" + totalBalance +
                ", interestRate=" + interestRate +
                ", activeLoan=" + activeLoan +
                ", dateOpening=" + dateOpening +
                ", isDebit=" + isDebit +
                ", card=" + card +
                ", debit=" + debit +
                ", loan=" + loan +
                '}';
    }
}
