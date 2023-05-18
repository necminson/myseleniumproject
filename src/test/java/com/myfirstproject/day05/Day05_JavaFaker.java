package com.myfirstproject.day05;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.util.Date;

public class Day05_JavaFaker {


    @Test
    public void javaFaker(){
        // 1. Create a faker object
        Faker faker = new Faker();
        // user faker object or generate fake test data
       String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);
        // last name
       String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);
        // title name
        String title = faker.name().title();
        System.out.println("title = " + title);
        // city
        String city = faker.address().city();
        // state
        String state = faker.address().state();
        // country
        String country = faker.address().country();
        // address
        String fulladdress = faker.address().fullAddress();
        System.out.println("fulladdress = " + fulladdress);
        // zip code
        String zipCode = faker.address().zipCode();
        System.out.println("zipCode = " + zipCode);
        // random number : 10 digit number
        String randomNumber = faker.number().digits(10);
        System.out.println("randomNumber = " + randomNumber);
        // cell phone number
        String phoneNumber = faker.phoneNumber().cellPhone();
        System.out.println("phoneNumber = " + phoneNumber);
        // ssn
        String idNumber = faker.idNumber().ssnValid();
        System.out.println("idNumber = " + idNumber);
        // email
        String email = faker.internet().emailAddress();
        System.out.println("email = " + email);
        // date
        Date date = faker.date().birthday();









    }
}
