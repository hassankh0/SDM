package Observer;

import Classes.Transaction;

public interface TransactionStatusSubject {
    void registerObserver(TransactionStatusObserver observer);
    void notifyObservers(Transaction transaction);
}
