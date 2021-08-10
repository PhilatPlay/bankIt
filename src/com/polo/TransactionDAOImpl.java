package com.polo;

import java.sql.*;
import java.util.List;

//import static java.time.LocalTime.now;

class TransactionDAOImpl implements TransactionDAO {

    private static Statement statement = null;
    Connection connection = null;

    public TransactionDAOImpl()  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addTransaction(Transaction transaction) throws SQLException {
        String sql = "insert into transaction (transaction_id, userId, amount, transactionLabel, receiver_id) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, transaction.getTransaction_id());
        preparedStatement.setInt(2, transaction.getUserId());
        preparedStatement.setDouble(3, transaction.getAmount());
        preparedStatement.setString(4, transaction.getTransactionLabel());
        preparedStatement.setInt(5, transaction.getReceiver_id());

        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Transaction saved");
        else
            System.out.println("Oops! something went wrong");
    }

    public void getUserTransactions (int id) throws SQLException {
        String sql = "SELECT * FROM Transaction where userId = ?";

        Statement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery(sql);

        int count = 0;

        while (result.next()){
            double amount = result.getDouble(3);
            String transactionLabel = result.getString(4);
            String date = result.getString(6);

            String output = "User #%d: %s - %s - %s";
            System.out.println(String.format(output, amount, transactionLabel, date));
        }
    }


    @Override
    public List<Transaction> getTransaction() {
        return null;
    }

    @Override
    public Transaction transactionById(int transaction_id) {
        return null;
    }


}
