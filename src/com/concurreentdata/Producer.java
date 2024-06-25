package com.concurreentdata;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable 
{
	// Private field to hold the blocking queue of transactions
	private final BlockingQueue<Transaction> queue;

	// Constant to define the maximum number of transactions to produce
	private static final int MAX_TRANSACTIONS = 10;

	// Constructor to initialize the producer with the provided queue
	public Producer(BlockingQueue<Transaction> queue)
	{
		this.queue = queue; // Assigns the provided queue to the field
	}

	// Override the run method to define the producer's behavior
	@Override
	public void run() 
	{
		try {
			// Loop to produce a defined number of transactions
			for (int i = 0; i < MAX_TRANSACTIONS; i++)
			{
				// Generate a unique transaction ID
				String transactionID = UUID.randomUUID().toString();

				// Get the current timestamp
				long timestamp = System.currentTimeMillis();

				// Randomly decide the type of transaction (BUY/SELL)
				String type = (Math.random() > 0.5) ? "BUY" : "SELL";

				// Randomly generate an amount for the transaction
				double amount = Math.random() * 1000;

				// Create a new transaction object with the generated values
				Transaction transaction = new Transaction(transactionID, timestamp, type, amount);

				// Put the transaction into the queue
				queue.put(transaction);

				// Print the produced transaction
				System.out.println("Produced: " + transaction);
			}
			// Add a poison pill for each consumer to signal them to stop
			for (int i = 0; i < TransactionProcessor.NUM_CONSUMERS; i++) {
				queue.put(new Transaction("POISON_PILL", 0, "", 0));
				
			}
		} catch (InterruptedException e)
		{
			// If interrupted, reset the interrupt status
			Thread.currentThread().interrupt();
		}
	}
}