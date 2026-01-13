package org.Moscow.services;

import org.Moscow.data.models.Transaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();

    @Override
    public void recordTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
}
