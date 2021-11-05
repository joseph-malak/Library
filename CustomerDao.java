package com.demo2;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    boolean getCustomerAccount(String userName, String password) throws SQLException;

    List<Customer> getBookList(String typeOfBook) throws SQLException;

    void NewAccount(String one, String two)throws SQLException;

    void getBook(int isbn) throws SQLException;

    void addToCart(int id, int isbn) throws SQLException;

    int getCustomerId(String userName, String password) throws SQLException;

    void emptyCart(int id) throws SQLException;

}
