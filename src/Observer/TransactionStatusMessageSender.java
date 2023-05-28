package Observer;

import Classes.Transaction;

public class TransactionStatusMessageSender implements TransactionStatusObserver {
        @Override
        public void update(Transaction transaction) {
            String message;
            if (transaction.isStatus()) {
                message = transaction.getTransactionType() + " transaction of " +transaction.getAmount()+" on "+
                        transaction.getDate() + " has been processed successfully";
            } else {
                message = transaction.getTransactionType() + " transaction of " +transaction.getAmount()+" on "+
                        transaction.getDate() + " has failed. Please review the issue";
            }

            // Code to send the message using your preferred messaging system
            sendMessage(message);
        }

        private void sendMessage(String message) {
            // Code to send the message using your preferred messaging system
            System.out.println("Transaction Alert: " + message);
        }
    }

