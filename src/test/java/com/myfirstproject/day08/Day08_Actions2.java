package com.myfirstproject.day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static com.myfirstproject.utilities.WaitForUtils.*;


public class Day08_Actions2 extends TestBase {


    @Test
    public void hoverOverTest(){
        //Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //When use click on “Account” link
            /*
            Account is hidden under menu.
            We need to move the mouse over the menu so account can be visible.
            We can hover menu  using actions
             */
        WebElement menu = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        waitFor(3000);
        driver.findElement(By.linkText("Account")).click();

        //Then verify the page title contains “Your Account”
        waitFor(3000);
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }


}
