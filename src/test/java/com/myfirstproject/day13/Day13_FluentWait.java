package com.myfirstproject.day13;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import java.time.Duration;

import static com.myfirstproject.utilities.ReusableMethodsUtils.explicitlyWaitFor_xPath;

public class Day13_FluentWait extends TestBase {

    //Create a method: fluentWait

        @Test
        public void fluentWaitTest(){
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
            WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
            startButton.click();
//        TRYING FLUENT WAIT
//        1. create Wait object
            Wait<WebDriver> wait = new FluentWait<>(driver)//creating wait object
                    .withTimeout(Duration.ofSeconds(30))//total wait
                    .pollingEvery(Duration.ofSeconds(2))//how often driver checks the element
                    .withMessage("Ignoring No Such Element Exception")//adding message
                    .ignoring(NoSuchElementException.class);//ignoring exception

//        2. use the wait object to handle the wait issue
           WebElement hello = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
            Assert.assertEquals("Hello World!",hello.getText());
        }
}
