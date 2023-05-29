package com.myfirstproject.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static com.myfirstproject.utilities.TestBase.driver;
import static org.junit.Assert.*;

public class AssertAndVerifyUtils {

    //    VERIFY ELEMENT TEXT EQUALS TO EXPECTED TEXT
    /**
     * Verifies whether the actual text of element on page equals to acceptance text
     * fails if they are not equal or not displayed
     *
     * @param element , acceptance text
     */
    public static void verifyElementTextAndExpectedTextsEquals(WebElement element,String text) {
        try {
            assertEquals( "Expected text does not equal to actual text : ",text,element.getText() );

        } catch (NoSuchElementException e) {
            org.junit.Assert.fail("Element is not found: " + element);
        }
    }
    //    VERIFY ELEMENT IS DISPLAYED
    /**
     * Verifies whether the element is displayed on page
     * fails if the element is not found or not displayed
     *
     * @param element
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element is not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            org.junit.Assert.fail("Element is not found: " + element);
        }
    }

    /**
     * Verifies whether the element matching the provided locator is displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementDisplayed(By by) {
        try {
            assertTrue("Element not visible: " + by, driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            org.junit.Assert.fail("Element not found: " + by);
        }
    }

    //VERIFY ELEMENT IS NOT DISPLAYED
    /**
     * Verifies whether the element matching the provided locator is NOT displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementNotDisplayed(By by) {
        try {
            assertFalse("Element should not be visible: " + by, driver.findElement(by).isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    /**
     * Verifies whether the element matching the provided WebElement is NOT displayed on page
     * fails if the element matching the WebElement is not found or not displayed
     * @paramWebElement
     */
    public static void verifyElementNotDisplayed(WebElement element) {
        try {
            assertFalse("Element should not be visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementClickable(WebElement element) {
        try {
            Assert.assertTrue("Element not visible: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }
    public static void verifyElementNotClickable(WebElement element) {
        try {
            Assert.assertFalse("Element not visible: " + element, element.isEnabled());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
