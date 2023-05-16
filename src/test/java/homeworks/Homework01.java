package homeworks;

import com.myfirstproject.utilities.TestBase;
import org.junit.*;
import org.openqa.selenium.*;


import java.util.List;

import static com.myfirstproject.utilities.ThreadSleepUtil.waitUpTo;

public class Homework01 extends TestBase {
    //Task01:
    @Test
    public void task01Test(){

    //Go to ebay page
        driver.get("https://www.ebay.com");
    //Click on electronics section
        driver.findElement(By.linkText("Electronics")).click();
    //Click on all the images with a Width of 225 and a Length of 225

        List<WebElement> images = driver.findElements(By.xpath("//img[@width='225'][@height='225']"));
        System.out.println("images = " + images);

        for (WebElement image: images ) {

            waitUpTo(5000);
            image.click();
            waitUpTo(5000);
            System.out.println("driver.getTitle() = " + driver.getTitle());

            driver.navigate().back();

        }
    //Print the page title of each page
    //Close the page

    }


//Task02:
    /*
    Create and Maximize the driver with the BeforeClass method and put implicit wait for 15 seconds
    Go to http://www.google.com in the before method
    With 3 different test methods:
     -Type "Desktop" in the search box and print the number of results
     -Type "Smartphone" in the search box and print the number of results
     -Type "Laptop" in the search box and print the number of results
    NOTE: Print the result numbers in After method
    Close driver with AfterClass method
     */

//Task03:
    /*
    Go to https://amazon.com
    Print all the options in the 'Departments' dropdown on the left side of the search box
    Search for each first five options and print titles
    */
}
