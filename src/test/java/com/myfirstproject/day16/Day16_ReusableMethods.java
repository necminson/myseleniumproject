package com.myfirstproject.day16;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.LoggerUtils;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static com.myfirstproject.utilities.DropdownUtils.selectByValue;
import static com.myfirstproject.utilities.JSUtils.*;
import static com.myfirstproject.utilities.ScreenShotUtils.*;
import static com.myfirstproject.utilities.WaitForUtils.*;
import static org.junit.Assert.assertEquals;


public class Day16_ReusableMethods extends TestBase {
    Faker faker;
    /*
    When user goes to https://www.automationexercise.com/
        And click on Sing up link
        And enter credentials and click sign up button
        And enter the information
        And click on Create Account
        Then verify the account creating is successful. Account Created! Element is displayed
     */
    @Test
    public void RegisterUserTest() throws Exception {
        faker = new Faker(); // By using faker object we can generate data, like fake firstname, fake lastname etc.

        LoggerUtils.info("Starting the Test Case .......");
        // When user goes to https://www.automationexercise.com/

        driver.get("http://automationexercise.com");
        extentTest.pass("Navigating the sign up page").addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString()).getStatus();


        //   Click on 'Signup / Login' button
        WebElement loginButton =explicitlyWaitForVisibility(By.xpath("//*[@href='/login']"),3);
        clickWithTimeOut(loginButton,6);

        //   Enter name and email address

        explicitlyWaitForVisibility(By.xpath("//input[@name='name']"),3).sendKeys(faker.name().name());
        explicitlyWaitFor_xPath("(//input[@name='email'])[2]",3).sendKeys(faker.internet().emailAddress());

        //  Click 'Signup' button
        WebElement signUpButton =explicitlyWaitFor_xPath("//button[@data-qa='signup-button']",3);
        clickByJS(signUpButton);

        extentTest.pass("Adding user information ...")
                  .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());

        //  Fill details: Title (Gender), Name, Email, Password, Date of birth
        clickByJS(explicitlyWaitForVisibility(By.id("id_gender1"),3));
        // Name & Email automatically filled.
        // Fill Password
        explicitlyWaitForVisibility(By.xpath("//input[@id='password']"),3).sendKeys(faker.internet().password());
        // Fill Date of birth
        selectByValue(explicitlyWaitForVisibility(By.xpath("//select[@id='days']"),3),"6");
        selectByValue(explicitlyWaitForVisibility(By.xpath("//select[@id='months']"),3),"10");
        selectByValue(explicitlyWaitForVisibility(By.xpath("//select[@id='years']"),3),"1971");
        //  Select checkbox 'Sign up for our newsletter!'
        clickByJS(explicitlyWaitForClickablility(By.id("newsletter"),3));
        //  Select checkbox 'Receive special offers from our partners!'
        clickByJS(explicitlyWaitForClickablility(By.id("optin"),3));
        //  Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        explicitlyWaitForVisibility(By.id("first_name"),3).sendKeys(faker.address().firstName());
        explicitlyWaitForVisibility(By.id("last_name"),3).sendKeys(faker.address().lastName());
        explicitlyWaitForVisibility(By.id("company"),3).sendKeys(faker.company().name());
        explicitlyWaitForVisibility(By.id("address1"),3).sendKeys(faker.address().fullAddress());
        explicitlyWaitForVisibility(By.id("address2"),3).sendKeys(faker.address().fullAddress());
        selectByValue(explicitlyWaitForVisibility(By.id("country"),3),"Canada");
        explicitlyWaitForVisibility(By.id("state"),3).sendKeys(faker.address().state());
        explicitlyWaitForVisibility(By.id("city"),3).sendKeys(faker.address().city());
        explicitlyWaitForVisibility(By.id("zipcode"),3).sendKeys(faker.address().zipCode());
        explicitlyWaitForVisibility(By.id("mobile_number"),3).sendKeys(faker.phoneNumber().cellPhone());

        extentTest.pass("Entering account information ...")
                  .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());

        // Click 'Create Account button'
        clickByJS(explicitlyWaitForVisibility(By.xpath("//*[@data-qa='create-account']"),30));

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        assertEquals("Expected and actual data do NOT equal...! ",explicitlyWaitForVisibility(By.xpath("//b"),3).getText(),"ACCOUNT CREATED!");

        extentTest.pass("Verifying 'ACCOUNT CREATED!'visibility ...")
                .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());


    }


    }
