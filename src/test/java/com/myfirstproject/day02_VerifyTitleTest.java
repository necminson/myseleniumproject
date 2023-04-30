package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class day02_VerifyTitleTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup(); // setup
        WebDriver driver = new ChromeDriver(); // create chrome driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//
        driver.manage().window().maximize();
        /*
        Create a new class: VerifyTitleTest 

        Navigate to techproeducation homepage 

        Verify if page title is “Techpro Education | Online It Courses & Bootcamps”

         */
        driver.get("https://techproeducation.com");
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }
        driver.quit();
    }
}
