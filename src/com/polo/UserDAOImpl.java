package com.polo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static Statement statement = null;
    Connection connection = null;

    public UserDAOImpl()  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
   public void addUser(User user) throws SQLException {
        String sql = "insert into user (id, name, email, age, role, accountBalance, loggedIn) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setInt(4, user.getAge());
        preparedStatement.setString(5, user.getRole());
        preparedStatement.setDouble(6, user.getAccountBalance());
        preparedStatement.setBoolean(7, user.getLoggedIn());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("Welcome! Let's start by depositing money into your new account"
                    + "\r\n"
                    + "\r\n"
                    + "What amount would you like to deposit today?");
        else
            System.out.println("Oops! something went wrong");
    }

    //  **********************************************************************************************THIS ONE NOT WRKING FOR ME
    @Override
    public void updateUserABalance(User user) throws SQLException {
        String sql = "update user set accountBalance = ? where id = ?";
        int count;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(6, user.getAccountBalance());
            preparedStatement.setInt(1, user.getId());
            count = preparedStatement.executeUpdate();
        }
        if(count > 0)
            System.out.println("Your account balance has been updated.");
        else
            System.out.println("Oops! something went wrong");
    }
    
    // **********************************************************************************************THIS just using as reference

    @Override
    public void updateUser(User user) throws SQLException {
        String sql = "update user set accountBalance = ?, where id= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setInt(4, user.getAge());
        preparedStatement.setString(5, user.getRole());
        preparedStatement.setDouble(6, user.getAccountBalance());
        preparedStatement.setBoolean(7, user.getLoggedIn());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("user updated");
        else
            System.out.println("Oops! something went wrong");
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        String sql = "delete from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("user delete");
        else
            System.out.println("Oops! something went wrong");
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User userById(int id) {
        return null;
    }
}
