package com.polo;

import java.sql.SQLException;
import java.util.List;

public interface   UserDAO {
    void addUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    void updateUserABalance(User user) throws SQLException;
    void deleteUser(int id) throws SQLException;
//    void Login(String email, String pass) throws SQLException;
    List<User> getUsers();
    User userById(int id);
}
