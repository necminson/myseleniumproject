package homeworks;

import com.myfirstproject.utilities.TestBase;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static com.myfirstproject.utilities.ReusableMethodsUtils.*;

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
        //Print the page title of each page
        for (WebElement image: images ) {

            waitFor(5000);
            image.click();
            waitFor(5000);
            System.out.println("driver.getTitle() = " + driver.getTitle());

            driver.navigate().back();

        }
        //Close the page  TestBase closes

    }

//Task02: //    With 3 different test methods:
    @Test
    public void task02ATest(){
        //  Create and Maximize the driver with the BeforeClass method and put implicit wait for 15 seconds (TestBase)
        //    Go to http://www.google.com in the before method
        driver.get("http://www.google.com");
       //     -Type "Desktop" in the search box and print the number of results
       WebElement searchBox = explicitlyWaitFor_id("APjFqb",30);
       searchBox.sendKeys("Desktop");
        driver.findElement(By.xpath("//input[@name='btnK']")).click();
        WebElement resultsNum = explicitlyWaitFor_xPath("//div[@id='result-stats']",30);
        System.out.println("Results Number = " + resultsNum.getText());
        //    NOTE: Print the result numbers in After method (TestBase)
        //    Close driver with AfterClass method (TestBase)
    }
    @Test
    public void task02BTest(){
        //  Create and Maximize the driver with the BeforeClass method and put implicit wait for 15 seconds (TestBase)
        //    Go to http://www.google.com in the before method
        driver.get("http://www.google.com");
        //     -Type "Smartphone" in the search box and print the number of results
        WebElement searchBox = explicitlyWaitFor_id("APjFqb",30);
        searchBox.sendKeys("Smartphone");
        driver.findElement(By.xpath("//input[@name='btnK']")).click();
        WebElement resultsNum = explicitlyWaitFor_xPath("//div[@id='result-stats']",30);
        System.out.println("Results Number = " + resultsNum.getText());
        //    NOTE: Print the result numbers in After method  (TestBase)
        //    Close driver with AfterClass method (TestBase)
    }
    @Test
    public void task02CTest(){
        //  Create and Maximize the driver with the BeforeClass method and put implicit wait for 15 seconds (TestBase)
        //    Go to http://www.google.com in the before method
        driver.get("http://www.google.com");
        //     -Type "Laptop" in the search box and print the number of results
        WebElement searchBox = explicitlyWaitFor_id("APjFqb",30);
        searchBox.sendKeys("Laptop");
        driver.findElement(By.xpath("//input[@name='btnK']")).click();
        WebElement resultsNum = explicitlyWaitFor_xPath("//div[@id='result-stats']",30);
        System.out.println("Results Number = " + resultsNum.getText());
        //    NOTE: Print the result numbers in After method
        //    Close driver with AfterClass method
    }



//Task03:

        @Test
    public void task03Test(){
            // Navigate to Amazon.com
            driver.get("https://www.amazon.com");
            // Locate the 'All Departments' dropdown
            WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

            // Print all the options in the dropdown
            Select select = new Select(dropdown);
            ArrayList<String> optionsList = new ArrayList<>();
            for (WebElement option : select.getOptions()) {
                optionsList.add(option.getText());
            }
            System.out.println("optionsList = " + optionsList);
            // Locate the search box and Search for each of the first five options and print the titles
            for (int i = 0; i <5; i++) {
                        // enter the selected option
                WebElement searchBox = explicitlyWaitFor_id("twotabsearchtextbox",30);
                        searchBox.sendKeys(optionsList.get(i));
                        // Submit the search
                        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
                        searchButton.click();
                        // Print the title of the first search result
                        String firstResult = driver.getTitle();
                        System.out.println("Title "+(i+1)+" : " + firstResult);
                        waitFor(5000);
                        driver.navigate().back();
                    }



        }
}
