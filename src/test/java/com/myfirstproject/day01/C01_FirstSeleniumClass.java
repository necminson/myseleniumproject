package com.myfirstproject.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_FirstSeleniumClass {
    public static void main(String[] args) {

        // We will not use main method later on
        System.setProperty("webdriver.chrome.driver","chromedriver.exe"); // Later we will not use this method
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techproeducation.com");
        driver.close();

    }

}
