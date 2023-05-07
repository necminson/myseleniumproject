package com.myfirstproject.practises.practise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.myfirstproject.utilities.ThreadSleepUtil.threadSleepUtil;

public class Q02_IfElse {
    // Set Driver Path
// Create chrome driver object
// Maximize the window
// Open google home page https://www.google.com/
// Wait for 3 seconds
// Go to the "https://techproeducation.com/"
// Get the title and URL of the page
// Check if the title contains the word "Bootcamps" print console "Title contains Bootcamps" or "Title does not contain Bootcamps"
// Check if the URL contains the word "Courses" print console "URL contains Courses" or "URL does not contain Courses"
// Then go to "https://medunna.com/"
// Get the title and check if it contains the word "MEDUNNA" and print "Title contains MEDUNNA" or "Title does not contain MEDUNNA"
// Navigate Back to the previous webpage
// Refresh the page
// Navigate to forward
// Wait for 3 seconds
// Close the browser
    @Test
    public void ifElseTest(){
        // Set Driver Path
        WebDriverManager.chromedriver().setup();
        // Create chrome driver object
        WebDriver driver = new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
        // Wait for 3 seconds
        threadSleepUtil(3000);
        // Go to the "https://techproeducation.com/"
        driver.navigate().to("https://techproeducation.com/");
        // Get the title and URL of the page
        String titleTechProEdu = driver.getTitle();
        String currentUrlTechPro = driver.getCurrentUrl();
        // Check if the title contains the word "Bootcamps" print console "Title contains Bootcamps"
        // or "Title does not contain Bootcamps"
        boolean bootCamp = driver.getTitle().contains("Bootcamps");
        if (bootCamp){
            System.out.println("Title contains Bootcamps");
        } else {
            System.out.println("Title does not contain Bootcamps");
        }

        // Check if the URL contains the word "Courses" print console "URL contains Courses"
        // or "URL does not contain Courses"
        boolean courses = driver.getCurrentUrl().contains("Courses");
        if (courses){
            System.out.println("URL contains Courses");
        }else {
            System.out.println("URL does not contain Courses");
        }

        // Then go to "https://medunna.com/"
        driver.navigate().to("https://medunna.com/");

        // Get the title and check if it contains the word "MEDUNNA" and print "Title contains MEDUNNA"
        // or "Title does not contain MEDUNNA"
        boolean medunna = driver.getTitle().contains("MEDUNNA");
        if (medunna){
            System.out.println("Title contains MEDUNNA");
        }else {
            System.out.println("Title does not contain MEDUNNA");
        }

        // Navigate Back to the previous webpage
        driver.navigate().back();
        // Refresh the page
        driver.navigate().refresh();
        // Wait for 3 seconds
        threadSleepUtil(3000);
        // Close the browser
        driver.close();
    }
}
