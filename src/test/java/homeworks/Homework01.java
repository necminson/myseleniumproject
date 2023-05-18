package homeworks;

import com.myfirstproject.utilities.TestBase;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static com.myfirstproject.utilities.ReusableMethodsUtils.waitFor;

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

            waitFor(5000);
            image.click();
            waitFor(5000);
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
    @Test
    public void task03Test(){

    //Go to https://amazon.com
    driver.get(" https://amazon.com");
    String windowHandle = driver.getWindowHandle();

    //Print all the options in the 'All Departments' dropdown on the left side of the search box

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select options = new Select(dropDown);
        options.getOptions().forEach(each-> System.out.println(each.getText()));
        System.out.println("******************************************************");
    //Search for each first five options and print titles
       List<WebElement>  firstFiveOptions = driver.findElements(By.xpath("//div[@role='button']"));
       firstFiveOptions.forEach(each-> System.out.println(each.getText()));
       /*
        for (int i=1;i<6 ;i++){
            driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
            waitFor(2000);
            WebElement firstFiveOptions = driver.findElement(By.xpath("(//div[@role='button'])["+i+"]"));
            waitFor(2000);
            clickByJS(firstFiveOptions);
            waitFor(2000);
            System.out.println("firstFiveOptions titles = " + driver.getTitle());
            waitFor(2000);
            driver.switchTo().window(windowHandle);
        }

        */
    }
        @Test
    public void Test01(){
            // Navigate to Amazon.com
            driver.get("https://www.amazon.com");

            // Locate the 'All Departments' dropdown
            WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

            // Print all the options in the dropdown
            Select select = new Select(dropdown);
            for (WebElement option : select.getOptions()) {
                System.out.println(option.getText());
            }

            // Search for each of the first five options and print the titles
            for (int i = 1; i <= 5; i++) {
                select.selectByIndex(i);

                // Locate the search box and enter the selected option
                WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
                searchBox.clear();
                searchBox.sendKeys(select.getFirstSelectedOption().getText());

                // Submit the search
                WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
                searchButton.click();

                // Print the title of the first search result
                WebElement firstResult = driver.findElement(By.cssSelector(".sg-col-inner h2 a span"));
                System.out.println("Title: " + firstResult.getText());
            }
        }
}
