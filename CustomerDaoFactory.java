package com.demo2;

public class CustomerDaoFactory {

    private static CustomerDao dao;

    private CustomerDaoFactory(){

    }

    public static CustomerDao getCustomerDao(){
        if(dao ==null) {
            dao = new CustomerDaoImlp();
        }
        return dao;
    }
}
