package com.myfirstproject.utilities;

import org.openqa.selenium.*;
import static com.myfirstproject.utilities.TestBase.*;
import static com.myfirstproject.utilities.WaitForUtils.*;

public class JSUtils {

    //*****************JAVASCRIPT EXECUTOR METHODS ****************
    /*
            //*****************SCROLL METHODS ****************
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
    // ************************************ CLICK METHODS ****************************
    /*
    @param WebElement
    clicks on that element
     */
    public static void clickByJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }
    public static void clickWithTimeoutByJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", explicitlyWaitForVisibility(element,5));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
                //***************** LOCATE ELEMENT METHODS ****************
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
