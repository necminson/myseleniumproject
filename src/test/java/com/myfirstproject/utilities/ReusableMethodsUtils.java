package com.myfirstproject.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static com.myfirstproject.utilities.TestBase.driver;

public class ReusableMethodsUtils {

    //********************* REUSABLE METHODS TO WAIT FOR ********************

    // This Method is used to wait for given time in milliseconds
    public static long waitFor(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return milis;
    }

    public static WebElement explicitlyWaitFor_xPath(String xPath,long seconds){
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xPath))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static WebElement explicitlyWaitFor_id(String id,long seconds){
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(id))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }
    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }
    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }



            // ********************  SCREENSHOT ********************************
   /*
This method captures screenshot of the entire page
 */
public void takeScreenshotOfTheEntirePage() throws Exception {
//        1. TakeScreenShot class with getScreenShotAs method to capture the screenshot
    File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        2. Create a path to save the image
//        Create a date for giving dynamic name otherwise the screenshots overrides
    String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting local date in this format
//                     CURRENT PROJECT FOLDER         foldername   subfoldername imagename
    String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+now+"image.png";
//        3. Save the image in the path as a file
    FileUtils.copyFile(image,new File(path));
//        FileUtils.copyFile(FILE,FILE PATH); COPY FILE TO THAT FILE PATH
}
    /*
    This method captures screenshot of specific elements
    this method accepts an elements and saves the screenshot of that element in the test-output folder
     */
    public void takeScreenshotOfThisElement(WebElement element) throws Exception {
        File image = element.getScreenshotAs(OutputType.FILE);
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/ElementScreenshot/"+now+"image.png";
        FileUtils.copyFile(image,new File(path));
    }
    /*
    This method captures the image and returns the path of that image
    RETURN TYPE : static String
    return new File(path).getAbsolutePath();
     */
    public static String takeScreenshotOfTheEntirePageAsString() throws Exception {
        //        1. TakeScreenShot class with getScreenShotAs method to capture the screenshot
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //        2. Create a path to save the image
        //        Create a date for giving dynamic name otherwise the screenshots overrides
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting local date in this format
        //                     CURRENT PROJECT FOLDER         foldername   subfoldername imagename
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+now+"image.png";
        //        3. Save the image in the path as a file
        FileUtils.copyFile(image,new File(path));
//        GETTING THE ABSOLUTE PATH OF THE IMAGE PATH THAT IS STRING
        return new File(path).getAbsolutePath();
    }
    //*****************JAVASCRIPT EXECUTOR METHODS ****************
    /*

    @param WebElement
    scrolls into that element
     */
    public static void scrollIntoViewJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    /*
    scroll all the way down
     */
    public static void scrollAllTheWayDownJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    /*
    scroll all the way up
     */
    public static void scrollAllTheWayUpJS(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }
    /*
    @param WebElement
    clicks on that element
     */
    public static void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }
    /*
    @param String id of the WebElement that we want to locate
    locating element using javascript executor
    and returns that WebElementChaat
    Note that this is NOT common and we should use 8 locators that we learned in selenium
     */
    /*
    @Param  : String Id of WebElement
    Returns : WebElement
     */
    public static WebElement locateElementByJS_Id(String idOfElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((WebElement)js.executeScript("return document.getElementById('"+idOfElement+"')"));
    }
    /*
     @Param  : String Name of WebElement
     Returns : WebElement
      */
    public static WebElement locateElementByJS_Name(String nameOfElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return ((WebElement)js.executeScript("return document.getElementByName('"+nameOfElement+"')"));
    }
    /*
    @param1 WebElement, @param2 String
    type the string in that web element
     */
    public static void setValueByJS(WebElement inputElement,String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','"+text+"')",inputElement);
    }

}
