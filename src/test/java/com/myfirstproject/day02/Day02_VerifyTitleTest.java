package com.myfirstproject.day02;

import com.myfirstproject.utilities.LoggerUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day02_VerifyTitleTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup(); // setup
        WebDriver driver = new ChromeDriver(); // create chrome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//
        driver.manage().window().maximize();
        /*
        Create a new class: VerifyTitleTesT

        Navigate to techproeducation homepage

        Verify if page title is “Techpro Education | Online It Courses & Bootcamps”

         */
        LoggerUtils.info("Starting the testing ... Opening the URL");
        driver.get("https://techproeducation.com");
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        LoggerUtils.info("Getting the page title...");
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Test passed");
            LoggerUtils.info("PASS...Page Title is "+driver.getTitle());
        } else {
            System.out.println("Test failed");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
            LoggerUtils.debug("FAIL...Page title is "+driver.getTitle());
        }
        driver.quit();
    }
}
