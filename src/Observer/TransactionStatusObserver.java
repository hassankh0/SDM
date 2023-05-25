package Observer;

import Classes.Transaction;

public interface TransactionStatusObserver {
    void update(Transaction transaction);

}
