package com.demo2;

public class Customer {
    public int getId() {
        return id;
    }

    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String author;
    private String userName;
    private String password;
    private double balances;
    private boolean login;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    private int isbn;

    public Customer(String title, String author, int isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
    }

    public boolean getLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }



    public Customer(String one, String two){
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Customer() {

    }

    public void getId(Customer customer){}
    public void setId(int id){
        this.id = id;
    }

    public String toString() {
        return "Title: "+ title +
                "\nAuthor: " + author +
                "\nISBN:" + isbn;
    }
}
