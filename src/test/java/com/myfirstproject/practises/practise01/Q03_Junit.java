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

public class Q03_Junit {
    // Create chrome driver by using @Before annotation and WebDriverManager
// Go to url : http://www.uitestpractice.com/
// Click on 'Form'
// Fill the First Name: John
// Fill the Last Name: Doe
// Check the Marital Status: Married
// Check the Hobby: Reading
// Select the Country : Canada
// Fill the Date Of Birth: 1st February 2000
// Fill the Phone Number: 12345
// Fill the User Name: john_doe
// Fill the Eamil: john@doe.com
// Fill the About Yourself: My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.
// Fill the Password: John.123
// Click on Submit Button
// Close the browser by using @After annotation
        WebDriver driver;
        @Before
        public void setUp(){
            // Create chrome driver by using @Before annotation and WebDriverManager
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
        }
        @Test
        public void junitTest(){
            // Go to url : http://www.uitestpractice.com/
            driver.get("http://www.uitestpractice.com/");
            // Click on 'Form'
            driver.findElement(By.partialLinkText("Form")).click();
            // Fill the First Name: John
            driver.findElement(By.id("firstname")).sendKeys("John");
            // Fill the Last Name: Doe
            driver.findElement(By.id("lastname")).sendKeys("Doe");
            // Check the Marital Status: Married
            driver.findElement(By.xpath("(//input[@name='optradio'])[1]")).click();

            // Check the Hobby: Reading
            driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

            // Select the Country : Canada
            WebElement selectCountry = driver.findElement(By.xpath("//select[@id='sel1']"));
            Select countryOptions = new Select(selectCountry);
            countryOptions.selectByVisibleText("Canada");

            // Fill the Date Of Birth: 1st February 2000
            driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("02/01/2000");
            // Fill the Phone Number: 12345
            driver.findElement(By.xpath("//*[@id='phonenumber']")).sendKeys("12345");
            // Fill the User Name: john_doe
            driver.findElement(By.xpath("//*[@id='username']")).sendKeys("john_doe");
            // Fill the Eamil: john@doe.com
            driver.findElement(By.xpath("//*[@id='email']")).sendKeys("john@doe.com");
            // Fill the About Yourself: My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.
            driver.findElement(By.xpath("//*[@id='comment']")).sendKeys("My name is John Doe. I am a famous man. Because my name is used as a mock data everywhere.");
            // Fill the Password: John.123
            driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys("John.123");
            // Click on Submit Button
            driver.findElement(By.xpath("//*[@type='submit']")).click();

    }

        @After
        public void tearDown(){
            // Close the browser by using @After annotation
            driver.close();
        }


}
