package com.demo2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CustomerDaoImlp implements CustomerDao {
    Connection connection;
    public double balance;
    Scanner scanner = new Scanner(System.in);

    Random rand = new Random();
    public int randomValue = (int) Math.floor(Math.random() * (100000));
    Customer customer = new Customer();

    public CustomerDaoImlp() {
        this.connection = ConnectionFactory.getConnection();
    }


    public int getCustomerId(String userName, String password) throws SQLException {
        String sql = "select id from user where user_name = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
          int id = resultSet.getInt(1);
            return id;
        } else {
        }
        return 0;
    }

    public void addToCart(int id, int isbn) throws SQLException {
        String sql1 = "insert into cart values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setInt(1, id);
        preparedStatement.setDouble(2, isbn);
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Book added to your cart");
        }
        else System.out.println("An error has occurred");
    }


    public boolean getCustomerAccount(String userName, String password) throws SQLException {
        String sql = "select * from user where user_name = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("That username, password combination is incorrect");
            return false;

        }
    }

    public List<Customer> getBookList(String typeOfBook) throws SQLException {
        List<Customer> employees = new ArrayList<>();
        String sql = "select * from books where type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, typeOfBook);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int isbn = resultSet.getInt(1);
            String author = resultSet.getString(3);
            String title = resultSet.getString(2);
            customer.setIsbn(isbn);
            customer.setAuthor(author);
            customer.setTitle(title);
            System.out.println(isbn = resultSet.getInt(1));
            Customer customer = new Customer(title, author, isbn);
            employees.add(customer);
        }
        return employees;
    }

    @Override
    public void getBook(int isbn) throws SQLException {
        String sql = "select * from books where isbn = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, isbn);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int bookNumber = resultSet.getInt(1);
            String title = resultSet.getString(2);
            String author = resultSet.getString(3);
            double price = resultSet.getDouble(4);
            String description = resultSet.getString(5);
            System.out.println("Title: " + title + "\nAuthor: " + author + "\nPrice: " + price + "\nISBN: " + bookNumber + "\nDescription: " + description );
        } else {
            System.out.println("That username, password combination is incorrect");

        }
    }

    public void NewAccount(String one, String two) throws SQLException {
        String sql = "insert into user (user_name, password) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, one);
        preparedStatement.setString(2, two);
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Customer saved!");
        else
            System.out.println("Oops! something went wrong");
    }

    public void emptyCart(int id) throws SQLException {
        String sql = "delete from cart where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int count = preparedStatement.executeUpdate();
        if (count > 0)
            System.out.println("Cart is now empty");
        else
            System.out.println("Oops! something went wrong");
    }

}

