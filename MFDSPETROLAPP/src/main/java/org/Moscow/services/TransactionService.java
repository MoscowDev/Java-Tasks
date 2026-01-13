package org.Moscow.services;

import org.Moscow.data.models.Transaction;
import java.util.List;

public interface TransactionService {
    void recordTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
}
