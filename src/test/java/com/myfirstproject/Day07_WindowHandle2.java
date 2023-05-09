package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

import static com.myfirstproject.utilities.ThreadSleepUtil.waitFor;

public class Day07_WindowHandle2 extends TestBase {
        /*
            Open 3 new windows and verify their TITLES
            Open 3 new tabs and verify their TITLES
         */
    @Test
    public void  newTabTest(){
        //        amazon title test
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        String amazonWindowHandle = driver.getWindowHandle();
        waitFor(5000);
        //        linkedIn title test
        driver.switchTo().newWindow(WindowType.TAB);// Create a NEW TAB and SWITCH TO IT
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedInWindowHandle = driver.getWindowHandle();
        waitFor(5000);
        //        ebay title test
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.ebay.com");
        Assert.assertTrue(driver.getTitle().contains("eBay"));
        String ebayWindowHandle= driver.getWindowHandle();
        waitFor(5000);

    // At this point driver is on EBAY, but I can switch to AMAZON or LinkedIn

        driver.switchTo().window(amazonWindowHandle); // driver is on the amazon now
        String amazonTitle = driver.getTitle();
        System.out.println("amazonTitle = " + amazonTitle);
        waitFor(5000);

        driver.switchTo().window(linkedInWindowHandle); // driver is on the LinkedIn now
        String linkedInTitle = driver.getTitle();
        System.out.println("linkedInTitle = " + linkedInTitle);
        waitFor(5000);

        driver.switchTo().window(ebayWindowHandle); // driver is on the ebay now
        String ebayTitle = driver.getTitle();
        System.out.println("ebayTitle = " + ebayTitle);

    }
    // copy method 1 body
    // change TAB --> WINDOW

    @Test
    public void  newWindowTest(){
        //        amazon title test
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        String amazonWindowHandle = driver.getWindowHandle();
        waitFor(5000);
        //        linkedIn title test
        driver.switchTo().newWindow(WindowType.WINDOW);// Create a NEW WINDOW and SWITCH TO IT
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedInWindowHandle = driver.getWindowHandle();
        waitFor(5000);
        //        ebay title test
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.ebay.com");
        Assert.assertTrue(driver.getTitle().contains("eBay"));
        String ebayWindowHandle= driver.getWindowHandle();
        waitFor(5000);

        // At this point driver is on EBAY, but I can switch to AMAZON or LinkedIn

        driver.switchTo().window(amazonWindowHandle); // driver is on the amazon now
        String amazonTitle = driver.getTitle();
        System.out.println("amazonTitle = " + amazonTitle);
        waitFor(5000);

        driver.switchTo().window(linkedInWindowHandle); // driver is on the LinkedIn now
        String linkedInTitle = driver.getTitle();
        System.out.println("linkedInTitle = " + linkedInTitle);
        waitFor(5000);

        driver.switchTo().window(ebayWindowHandle); // driver is on the ebay now
        String ebayTitle = driver.getTitle();
        System.out.println("ebayTitle = " + ebayTitle);
        waitFor(5000);
    }
    /*  INTERVIEW QUESTION
            What do you do when your automation script FAILS?
        ANSWER :
        1. Run automation script again to make sure it fails again
        2. Do one more time manual testing to see if there is a bug
        2a. If you see a bug, then check with devs to make sure that is a bug, then raise a bug ticket if needed. If that is a real bug, then dev fix, and I retest until I observe no more bug, then close the ticket.
        2b. If you DO NOT see any problem then go following steps
        3.  Check the automation script
        3a. Locator might be wrong
        3b. Test data maybe invalid(credentials, URL, environment,…)
        3c. Typo in the data or locator
        3c. If locator, data, env,… is correct then of following steps
        4. Check if there is an iframe
        Switch to frame
        5. Check if there is an alert
        Switch to alert
        6. New window
        Switch to the window
        7. Wait issue(Syncronization issue)
        Add more wait and use EXPLICIT WAIT(WE WILL LEARN LATER)
     */
}
