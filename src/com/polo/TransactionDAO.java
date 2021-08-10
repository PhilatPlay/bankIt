package com.polo;

import java.sql.SQLException;
import java.util.List;

interface TransactionDAO {
    void addTransaction(Transaction transaction) throws SQLException;
    void getUserTransactions(int id) throws SQLException;
//    void updateTransaction(Transaction transaction) throws SQLException;
//    void deleteTransaction(int transaction_id) throws SQLException;
    List<Transaction> getTransaction();
    Transaction transactionById(int transaction_id);
}
