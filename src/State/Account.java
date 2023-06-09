package State;

import Classes.Card;
import Classes.Debit;
import Classes.Loan;
import Classes.Transaction;
import Command.Command;
import Observer.TransactionStatusObserver;
import Observer.TransactionStatusSubject;
import State.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account implements TransactionStatusSubject {
    private int accountId;
    private float totalBalance;
    private AccountState state = null;
    private boolean activeLoan;
    private Date dateOpening;
    private boolean isDebit;
    private Card card;
    private Debit debit;
    private Loan loan;
    private List<Transaction>transactions;
    private List<TransactionStatusObserver> observers;


    public Account() {
        this.accountId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        this.isDebit = false;
        this.activeLoan = false;
        this.dateOpening = new Date();
        this.card = new Card();
        this.debit = new Debit(1000);
        this.transactions = new ArrayList<Transaction>();
        this.observers = new ArrayList<>();

        this.state = new RegularAccount();

    }

    @Override
    public void registerObserver(TransactionStatusObserver observer) {
        observers.add(observer);
    }


    @Override
    public void notifyObservers(Transaction transaction) {
        for (TransactionStatusObserver observer : observers) {
            observer.update(transaction);
        }
    }

    public void doCommand(Command cmd) {
        cmd.execute();
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

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public boolean deposit(float amount) {
        if (amount <= 0) {
//            System.out.println("Invalid deposit amount.");
            return false;
        }

        this.totalBalance += amount;
        return true;
    }

    public boolean withdraw(float amount) {
        if (amount <= 0) {
//            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (amount > this.totalBalance) {
            if (this.isDebit){
                this.totalBalance -= amount;
                return true;
            }
            else {

//                System.out.println("Insufficient funds.");
                return false;
            }
        }
        else {
            this.totalBalance -= amount;
            return true;
        }
    }

    public boolean makeLoan(float amount, Date dueDate) {
        if (this.activeLoan) {
            return false;
        }

        this.loan = new Loan(amount,this.state.getInterestRate(), dueDate);
        this.activeLoan = true;
        this.totalBalance += amount;
        return true;
    }

    public void makePremiumAccount(){
        this.state = new PremiumAccount();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransactions(Transaction transaction) {
        this.transactions.add(transaction);
        notifyObservers(transaction); // Notify observers of the new transaction
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", totalBalance=" + totalBalance +
                ", activeLoan=" + activeLoan +
                ", dateOpening=" + dateOpening +
                ", isDebit=" + isDebit +
                ", card=" + card +
                ", debit=" + debit +
                ", loan=" + loan +
                '}';
    }


}
