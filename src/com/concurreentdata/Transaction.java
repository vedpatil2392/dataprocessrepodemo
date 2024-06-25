package com.concurreentdata;

import java.util.Objects;

public class Transaction
{
    private final String transactionId;
    private final long timestamp;
    private final String transactionType;
    private final double amount;

    public Transaction(String transactionId, long timestamp, String transactionType, double amount) 
    {
        this.transactionId = Objects.requireNonNull(transactionId);
        this.timestamp = timestamp;
        this.transactionType = Objects.requireNonNull(transactionType);
        this.amount = amount;
    }

    public String getTransactionId() 
    {
        return transactionId;
    }

    public long getTimestamp() 
    {
        return timestamp;
    }

    public String getTransactionType()
    {
        return transactionType;
    }

    public double getAmount()
    {
        return amount;
    }

    @Override
    public String toString()
    {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", timestamp=" + timestamp +
                ", transactionType='" + transactionType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
