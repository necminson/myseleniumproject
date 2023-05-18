package com.myfirstproject.day13;

import com.google.j2objc.annotations.Weak;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.myfirstproject.utilities.ReusableMethodsUtils.*;

// Create a class:ExplicitWait
public class Day13_ExplicitWait extends TestBase {

    //Create a method: explicitWait
    @Test
    public void explicitWait(){
        //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //When user clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();
        // Wait after button click
        //waitFor(10000); // Solves the wait issue problem but not recommended
        // Trying extra wait implicit wait but it is also not recommended
        // Trying Explicit wait // It is recommended
        // 1. Create WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        // 2. Use the wait object to handle to wait issue

        WebElement helloWord =wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='finish']//h4"))));


        //Then verify the ‘Hello World!’ Shows up on the screen
        Assert.assertEquals("Hello World!",helloWord.getText());
    }
        @Test
            public void explicitWaitTest(){
            //Go to https://the-internet.herokuapp.com/dynamic_loading/1
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
            //When user clicks on the Start button
            WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
            startButton.click();
            // Wait element using element
            WebElement helloWord = explicitlyWaitFor_xPath("//div[@id='finish']//h4",30);
            Assert.assertEquals("Hello World!",helloWord.getText());
        }
}
