package com.demo2;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        int id;
        int holdValue;
        int input = 0;
        int input2 = 2;
        int welcomeLoop = 0;
        int bookLoop = 0;
        int bookSelect;
        Customer customermain = new Customer();
        String yes = null;
        String one;
        String two;
        String three;
        boolean login;
        CustomerDao dao = CustomerDaoFactory.getCustomerDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Barn of Books");
        while ( input != 3) {
            System.out.println("If you are a returning customer 1:\n" +
                    "If you are a new user... please enter 2 to get Started!\n" +
                    "If you would like to exit enter 3:");
            input = scanner.nextInt();
            int a = input;
            if (a == 1) {
                scanner.nextLine();
                System.out.println("Please enter your UserName:");
                one = scanner.nextLine();
                System.out.println("Please enter your Password:");
                two = scanner.nextLine();

                login = dao.getCustomerAccount(one, two);
                if(login == true){
                    String typeOfBook;
                    customermain.setUserName(one);
                    customermain.setPassword(two);
                    id = dao.getCustomerId(one,two);
                    while(bookLoop != 5){
                        System.out.println("To see Fantasy books enter 1:\n" +
                                "To see Horror then enter 2:\n" +
                                "To see History books enter 3:\n" +
                                "To see Sci-fi books 4:\n" +
                                "To checkout enter 5\n" +
                                "To exit enter 6:");
                        bookLoop = scanner.nextInt();
                        if(bookLoop == 1){
                            typeOfBook = "Fantasy";
                            List<Customer> customers = dao.getBookList(typeOfBook);
                            for (Customer customer : customers) {
                                System.out.println(customer);
                            }
                            System.out.println("Please type in the ISBN of the book you would like to see:");
                            bookSelect = scanner.nextInt();
                            holdValue = bookSelect;
                            dao.getBook(bookSelect);
                            System.out.println("Would you like to add this book to your cart? 1: yes, 2: no");
                            input2 = scanner.nextInt();
                            if(input2 == 1 ){
                                dao.addToCart(id,holdValue);
                                bookLoop = 0;
                            }
                            scanner.nextLine();
                        }



                        else if(bookLoop ==2){
                                typeOfBook = "Horror";
                            List<Customer> customers = dao.getBookList(typeOfBook);
                            for (Customer customer : customers) {
                                System.out.println(customer);
                            }
                            System.out.println("Please type in the ISBN of the book you would like to see:");
                            bookSelect = scanner.nextInt();
                            holdValue = bookSelect;
                            dao.getBook(bookSelect);
                            System.out.println("Would you like to add this book to your cart? 1: yes, 2: no");
                            input2 = scanner.nextInt();
                            if(input2 == 1 ){
                                dao.addToCart(id,holdValue);
                                bookLoop = 0;
                            }
                            scanner.nextLine();
                            }


                        else if(bookLoop ==3){
                            typeOfBook = "History";
                            List<Customer> customers = dao.getBookList(typeOfBook);
                            for (Customer customer : customers) {
                                System.out.println(customer);
                            }
                            System.out.println("Please type in the ISBN of the book you would like to see:");
                            bookSelect = scanner.nextInt();
                            holdValue = bookSelect;
                            dao.getBook(bookSelect);
                            System.out.println("Would you like to add this book to your cart? 1: yes, 2: no");
                            input2 = scanner.nextInt();
                            if(input2 == 1 ){
                                dao.addToCart(id,holdValue);
                                bookLoop = 0;
                            }
                            scanner.nextLine();
                        }


                        else if(bookLoop ==4){
                            typeOfBook = "Sci_Fi";
                            List<Customer> customers = dao.getBookList(typeOfBook);
                            for (Customer customer : customers) {
                                System.out.println(customer);
                            }
                            System.out.println("Please type in the ISBN of the book you would like to see:");
                            bookSelect = scanner.nextInt();
                            holdValue = bookSelect;
                            dao.getBook(bookSelect);
                            System.out.println("Would you like to add this book to your cart? 1: yes, 2: no");
                            input2 = scanner.nextInt();
                            if(input2 == 1 ){
                                dao.addToCart(id,holdValue);
                                bookLoop = 0;
                            }
                            scanner.nextLine();
                        }


                        else if(bookLoop ==5) {
                                dao.emptyCart(id);
                        }

                        else{
                            System.out.println("Exiting.....");
                            break;
                        }
                    }



                }
            }
            if(a == 2){
                scanner.nextLine();
                System.out.println("Please enter your UserName:");
                one = scanner.nextLine();
                System.out.println("Please enter your Password:");
                two = scanner.nextLine();
                dao.NewAccount(one,two);
            }
            if(a==3){
                break;
            }
        }
        System.out.println("PLease come again!");
    }
}