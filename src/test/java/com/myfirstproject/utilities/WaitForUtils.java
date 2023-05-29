package com.myfirstproject.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.myfirstproject.utilities.TestBase.driver;

public class WaitForUtils {
    //********************* REUSABLE METHODS TO WAIT FOR ********************

    // This Method is used to wait for given time in milliseconds
    public static long waitFor(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return millis;
    }

    public static WebElement explicitlyWaitFor_xPath(String xPath, int seconds){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xPath))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static WebElement explicitlyWaitFor_id(String id,int seconds){
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
            return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(id))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//
    public static WebElement explicitlyWaitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement explicitlyWaitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement explicitlyWaitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement explicitlyWaitForClickablility(By locator, int timeout) {
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
    public static void explicitlyWaitForPageToLoad(long timeout) {
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

}
