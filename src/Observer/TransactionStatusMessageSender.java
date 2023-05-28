package Observer;

import Classes.Transaction;

public class TransactionStatusMessageSender implements TransactionStatusObserver {
        @Override
        public void update(Transaction transaction) {
            String message;
            if (transaction.isStatus()) {
                message = "Transaction successful: " + transaction.getTransactionType();
            } else {
                message = "Transaction failed: " + transaction.getTransactionType();
            }

            // Code to send the message using your preferred messaging system
            sendMessage(message);
        }

        private void sendMessage(String message) {
            // Code to send the message using your preferred messaging system
            System.out.println("Sending message: " + message);
        }
    }

