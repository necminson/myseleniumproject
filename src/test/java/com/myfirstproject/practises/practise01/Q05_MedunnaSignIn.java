package com.myfirstproject.practises.practise01;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q05_MedunnaSignIn extends TestBase {

    @Test
    public void medunnaSignIn(){
        //Go to https://www.medunna.com/
        driver.get("https://www.medunna.com/");
        // click on "human symbol"
        driver.findElement(By.id("account-menu")).click();
        // click on "sing in"
        driver.findElement(By.id("login-item")).click();
        // Enter "mark_twain"
        driver.findElement(By.id("username")).sendKeys("mark_twain");
        // Enter Password as "mark.123"
        driver.findElement(By.id("password")).sendKeys("Mark.123");
        // clik on "remember me"
        driver.findElement(By.id("rememberMe")).click();
        // click on "sign in" submit button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Assert that you sign in
        String actualSignUpName= driver.findElement(By.xpath("//*[text()='Mark Twain']")).getText();
        String expectedSignUpName="Mark Twain";
        Assert.assertEquals(expectedSignUpName,actualSignUpName);
    }

}
