package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02_Navigations {
    public static void main(String[] args) {
        // 1 Set up
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        // 2. Create the driver object
        WebDriver driver= new ChromeDriver();
        // Now that we have our driver instance , we can start creating our test script

        // Open google home page https://www.walmart.com/.
        driver.get("https://www.walmart.com/");
        // Maximize the window
        driver.manage().window().maximize();
        // On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        // Navigate back to google
        driver.navigate().back();
        // Navigate forward to amazon
        driver.navigate().forward();
        // Refresh the page
        driver.navigate().refresh();
        // Close/Quit the browser
        driver.quit();
        //driver.close();
        /*
         *****What is the difference between get and navigate to functions?
         * Similarities : both let you go to a page
         * get is more common that navigate to. it is easy to read
         * get accepts ONLY String as url, navigate to accepts both string and URL
         * navigate has more options such as to(), back(), forward(), refresh()
         *
         *****What is the difference between close and quit?
         *close closed ONLY the last active window
         *quit closes ALL ACTIVE windows
         *recommendation is use quit at the end of the last test case
         */





    }

}
