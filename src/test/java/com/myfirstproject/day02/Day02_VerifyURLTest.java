package com.myfirstproject.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_VerifyURLTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        /*
        Create a new class: VerifyURLTest
        Navigate to TechProEducation homepage
        Verify if google homepage url is “https://techproeducation.com/”
         */
        driver.get("https://techproeducation.com");
        String actualCurrentURL =driver.getCurrentUrl();
        String expectedCurrentURL ="https://techproeducation.com/";
        if (expectedCurrentURL.equals(actualCurrentURL)){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            System.out.println("expectedCurrentURL = " + expectedCurrentURL);
            System.out.println("actualCurrentURL = " + actualCurrentURL);
        }
        driver.quit();


    }

}
