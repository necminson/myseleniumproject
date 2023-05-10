package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static com.myfirstproject.utilities.ThreadSleepUtil.waitUpTo;

//Create a class: ActionClass3

public class Day08_Actions3 extends TestBase {

    //Create test method : scrollUpDown()
    @Test
    public void scrollUpDown(){
        //Go to amazon
        driver.get("https://www.amazon.com/");
        //Scroll the page down
        /*
        scrolling is mouse or keyboard action so we should use Actions Class
        Keys.PAGE_DOWN : scroll page down more
        Keys.ARROW_DOWN : scroll page down a little bit
        alternatively, we will use javascript executor
         */
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        waitUpTo(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        waitUpTo(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        waitUpTo(2000);
            // We can chain these methods
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .build()    // built is recommended especially after method chains,
                            // but it can also be used any time before perform()
                .perform();// execute
        waitUpTo(2000);

        //Scroll the page up
        actions.sendKeys(Keys.PAGE_UP).perform(); // scrolling page up more
        waitUpTo(2000);
        actions.sendKeys(Keys.ARROW_UP).perform();// scrolling page up a little bit
        waitUpTo(2000);
    }

}
