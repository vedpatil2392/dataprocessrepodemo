package com.concurreentdata;

	



// Imports necessary classes for using blocking queues
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TransactionProcessor 
{
	// Constant to define the number of consumer threads
	public static final int NUM_CONSUMERS = 5;

	// Main method to start the application
	public static void main(String[] args) {
		// Creates a new blocking queue to hold transactions
		BlockingQueue<Transaction> queue = new LinkedBlockingQueue<>();

		// Creates a new TransactionHistory object to store processed transactions
		TransactionHistory transactionHistory = new TransactionHistory();

		// Creates and starts the producer thread
		Thread producerThread = new Thread(new Producer(queue));
		producerThread.start();

		// Creates and starts consumer threads
		for (int i = 0; i < NUM_CONSUMERS; i++) 
		{
			Thread consumerThread = new Thread(new Consumer(queue, transactionHistory));
			consumerThread.start();
		}
	}
}
