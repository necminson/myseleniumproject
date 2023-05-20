package com.myfirstproject.day14;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class Day14_NullPointerException {
    Faker faker;
    WebDriver driver;
    @Test
    public void nullPointerExceptionTest01(){
        driver.get("https://www.amazon.com"); //NullPointerException cause driver has no assigned value.(not instantiated)

    }

    @Test
    public void nullPointerExceptionTest02(){
        System.out.println(faker.name().firstName());//NullPointerException
    }
}
