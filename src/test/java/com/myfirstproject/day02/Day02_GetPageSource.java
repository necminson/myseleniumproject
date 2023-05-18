package com.myfirstproject.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_GetPageSource {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // setup
        WebDriver driver = new ChromeDriver(); // create chrome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//
        driver.manage().window().maximize();

        /*
        Test if amazon contains “Registry” on the homepage
         */
        driver.get("https:www.amazon.com");
        String pageSource = driver.getPageSource();
        if (pageSource.contains("Registry")){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
            System.out.println("Registry does not exist");
        }
        driver.quit();
    }
}
