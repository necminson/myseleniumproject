package com.myfirstproject.day09;

import com.myfirstproject.utilities.TestBase;
import org.junit.*;
import org.openqa.selenium.*;

public class Day09_Authentication extends TestBase {
    @Test
    public void authTest(){
        /*
        username: admin
        password:admin
        url     :the-internet.herokuapp.com/basic_auth
         */
//        driver.get("http://the-internet.herokuapp.com/basic_auth");
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

//        assert if login is successfull
        String actualLoginText = driver.findElement(By.xpath("//div[@id='content']//p")).getText();
        Assert.assertTrue(actualLoginText.contains("Congratulations!"));
    }
}
