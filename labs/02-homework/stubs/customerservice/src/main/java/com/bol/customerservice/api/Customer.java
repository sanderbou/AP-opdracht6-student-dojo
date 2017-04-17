package com.bol.customerservice.api;

import java.io.RandomAccessFile;

public class Customer {
    private final Long customerNumber;
    private final String firstName, lastName, emailAddress;

    public Customer(Long customerNumber, String firstName, String lastName, String emailAddress) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void writeCustomerToFile(){
        try {
            RandomAccessFile raf = new RandomAccessFile("service.db", "rw");
            raf.writeChars(this.toString());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
