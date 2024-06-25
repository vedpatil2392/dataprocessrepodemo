package com.concurreentdata;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
		// Private field to hold the blocking queue of transactions
		private final BlockingQueue<Transaction> queue;

		// Private field to hold the transaction history
		private final TransactionHistory transactionHistory;

		// Constructor to initialize the consumer with the provided queue and
		// transaction history
		public Consumer(BlockingQueue<Transaction> queue, TransactionHistory transactionHistory) {
			this.queue = queue; // Assigns the provided queue to the field
			this.transactionHistory = transactionHistory; // Assigns the provided transaction history to the field
		}

		// Override the run method to define the consumer's behavior
		@Override
		public void run() {
			try {
				while (true) {
					// Take a transaction from the queue
					Transaction transaction = queue.take();

					// Check if the transaction is a poison pill to signal the consumer to stop
					if (transaction.getTransactionId().equals("POISON_PILL")) {
						break; // Stop the consumer if a poison pill is encountered
					}

					// Print the consumed transaction
					System.out.println("Consumed: " + transaction);

					// Add the transaction to the transaction history
					transactionHistory.add(transaction);
				}
			} catch (InterruptedException e) {
				// If interrupted, reset the interrupt status
				Thread.currentThread().interrupt();
			}
		}
	}

