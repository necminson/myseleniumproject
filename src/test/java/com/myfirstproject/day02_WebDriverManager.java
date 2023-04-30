package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class day02_WebDriverManager {
    public static void main(String[] args) {
        /*
        // without WebDriverManager

        // Testing on chrome
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // Testing on firefox
        System.setProperty("webdriver.firefox.driver","firefoxdriver.exe");
        WebDriver driver = new FirefoxDriver();
        // Testing on edge
        System.setProperty("webdriver.edge.driver","edgedriver.exe");
        WebDriver driver = new EdgeDriver();

        //  // with WebDriverManager

        WebDriverManager.firefoxdriver().setup();// Testing on firefox
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.techproeducation.com");
        driver.close();

        WebDriverManager.edgedriver().setup();// Testing on edge
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.techproeducation.com");
        driver.close();
         */
        WebDriverManager.chromedriver().setup();// Testing on chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.techproeducation.com");
        driver.close();



    }
}
