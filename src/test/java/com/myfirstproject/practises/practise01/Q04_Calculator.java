package com.myfirstproject.practises.practise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q04_Calculator {


    WebDriver driver;
    @Before
    public void setUp(){
        // Create chrome driver by using @Before annotation and WebDriverManager
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void additionTest(){
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculator under Micro Apps
        driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("23");
        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("43");
        // Click on Calculate
        driver.findElement(By.id("calculate")).click();
        // Get the result
        driver.findElement(By.id("answer")).getText();
        // Verify the result
        Assert.assertEquals("66",driver.findElement(By.id("answer")).getText());
        // Print the result
        System.out.println(driver.findElement(By.id("answer")).getText());

    }
    @Test
    public void mutiplicationTest(){

            // Navigate to  https://testpages.herokuapp.com/styled/index.html
            driver.get("https://testpages.herokuapp.com/styled/index.html");

            // Click on  Calculator under Micro Apps
            driver.findElement(By.xpath("//a[@id='calculatetest']")).click();
            // Type any number in the first input
            driver.findElement(By.id("number1")).sendKeys("23");
            // Type any number in the second input
            driver.findElement(By.id("number2")).sendKeys("11");

            // chance operation to multiplication
            WebElement operationDropDown = driver.findElement(By.id("function"));
            Select operationOptions = new Select(operationDropDown);
            operationOptions.selectByVisibleText("times");

            // Click on Calculate
            driver.findElement(By.id("calculate")).click();
            // Get the result
            driver.findElement(By.id("answer")).getText();
            // Verify the result
            Assert.assertEquals("253",driver.findElement(By.id("answer")).getText());
            // Print the result
            System.out.println(driver.findElement(By.id("answer")).getText());


    }
    @After
    public void tearDown(){
        // Close the browser by using @After annotation
        driver.close();
    }

}
