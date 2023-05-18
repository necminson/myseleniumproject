package com.myfirstproject.day12;

import com.myfirstproject.utilities.TestBase;
import static com.myfirstproject.utilities.ReusableMethodsUtils.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;



public class Day12_JSExecutor extends TestBase {

    @Test
    public void scrollIntoViewTest() throws IOException {
        driver.get("https://www.amazon.com");
//        Location footer element on amazon page
        WebElement footer = driver.findElement(By.xpath("//div[@id='navFooter']//tbody"));
//        scroll into that element
        scrollIntoViewJS(footer);
//        assert if that footer is exists on the page
        Assert.assertTrue(footer.isDisplayed());
//        take a screenshot of the page
        takeScreenshotOfTheEntirePage();
//        locate the search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
//        and scroll into that element
        scrollIntoViewJS(searchBox);
//        then verify the element is displayed
        Assert.assertTrue(searchBox.isDisplayed());
//        then take screenshot
        takeScreenshotOfTheEntirePage();
    }
    @Test
    public void scrollAllTheWayUpDownTest() throws IOException, InterruptedException {
        driver.get("https://www.amazon.com");
//        scroll all the way down and take a screenshot of the page
        scrollAllTheWayDownJS();
        takeScreenshotOfTheEntirePage();
        Thread.sleep(3000);
        scrollAllTheWayUpJS();
        takeScreenshotOfTheEntirePage();
    }
    @Test
    public void clickByJSTest() throws InterruptedException, IOException {
//        search porcelain tea set on amazon
        driver.get("https://www.amazon.com");
//        location search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
//        typing porcelain tea set
        searchBox.sendKeys("porcelain tea set");
        Thread.sleep(5000);
        takeScreenshotOfTheEntirePage();
//        locating search button and clicking on it with js executor
        WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
        clickByJS(searchIcon);//JS CLICK
        takeScreenshotOfTheEntirePage();
    }
    @Test
    public void locateElementByJSTest(){
        driver.get("https://www.amazon.com");
        WebElement searchBox = locateElementByJS_Id("twotabsearchtextbox");
        searchBox.sendKeys("porcelain tea set");
        WebElement searchIcon = locateElementByJS_Id("nav-search-submit-button");
        clickByJS(searchIcon);

    }
    @Test
    public void typeWithJSTest(){
        driver.get("https://www.amazon.com");
        //        location search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        // Type the search box using by JS
        setValueByJS(searchBox,"porcelain tea set");
        WebElement searchIcon = locateElementByJS_Id("nav-search-submit-button");
        clickByJS(searchIcon);
    }
}