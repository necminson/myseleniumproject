package homeworks;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.myfirstproject.utilities.ReusableMethodsUtils.*;

public class TC01_RegisterUserTest extends TestBase {
    Faker faker;
    @Test
    public void RegisterUserTest(){

    //  1. Launch browser
    //  2. Navigate to url 'http://automationexercise.com'
    driver.get("http://automationexercise.com");


    // 3. Verify that home page is visible successfully
    String actualURL = driver.getCurrentUrl();
    String expectedURL= "https://automationexercise.com/";
    Assert.assertEquals(expectedURL,actualURL);
    //  4. Click on 'Signup / Login' button
    WebElement loginButton = driver.findElement(By.xpath("//*[@href='/login']"));
    clickByJS(loginButton);
    //  5. Verify 'New User Signup!' is visible
    boolean newUserSignUp = driver.findElement(By.xpath("(//h2)[3]")).isDisplayed();
    Assert.assertTrue(newUserSignUp);

    faker = new Faker(); // By using faker object we can generate data, like fake firstname, fake lastname etc.

    //  6. Enter name and email address
    String fakeName = faker.name().name();
    String fakeEmail = faker.internet().emailAddress();

    driver.findElement(By.xpath("//input[@name='name']")).sendKeys(fakeName);
    driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(fakeEmail);

    // 7. Click 'Signup' button
    WebElement signUpButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
    clickByJS(signUpButton);
    // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    boolean enterAccInfo = driver.findElement(By.xpath("//b")).isDisplayed();
    Assert.assertTrue(enterAccInfo);


    // 9. Fill details: Title, Name, Email, Password, Date of birth
    WebElement gender1 = driver.findElement(By.id("id_gender1"));
    clickByJS(gender1);
    // Name & Email automatically filled.
    // Fill Password
    String fakePassword = faker.internet().password();
    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(fakePassword);
    // Fill Date of birth
     WebElement daysOptions = driver.findElement(By.xpath("//select[@id='days']"));
     Select selectDay = new Select(daysOptions);
     selectDay.selectByValue("6");

     WebElement monthsOptions = driver.findElement(By.xpath("//select[@id='months']"));
     Select selectMonth = new Select(monthsOptions);
     selectMonth.selectByValue("10");

     WebElement yearsOptions = driver.findElement(By.xpath("//select[@id='years']"));
     Select selectYear = new Select(yearsOptions);
     selectYear.selectByValue("1971");

     // 10. Select checkbox 'Sign up for our newsletter!'
     driver.findElement(By.id("newsletter")).click();

     // 11. Select checkbox 'Receive special offers from our partners!'
     driver.findElement(By.id("optin")).click();

     // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
     String fakeFirstName = faker.address().firstName();
     String fakeLastName = faker.address().lastName();
     String fakeCompanyName = faker.company().name();
     String fakeAddress01 = faker.address().fullAddress();
     String fakeAddress02 = faker.address().fullAddress();
     String fakeState = faker.address().state();
     String fakeCity = faker.address().city();
     String fakeZipCode = faker.address().zipCode();
     String fakePhoneNumber = faker.phoneNumber().cellPhone();

     driver.findElement(By.id("first_name")).sendKeys(fakeFirstName);
     driver.findElement(By.id("last_name")).sendKeys(fakeLastName);
     driver.findElement(By.id("company")).sendKeys(fakeCompanyName);
     driver.findElement(By.id("address1")).sendKeys(fakeAddress01);
     driver.findElement(By.id("address2")).sendKeys(fakeAddress02);

     WebElement countryOptions = driver.findElement(By.id("country"));
     Select selectCountry = new Select(countryOptions);
     selectCountry.selectByValue("Canada");

     driver.findElement(By.id("state")).sendKeys(fakeState);
     driver.findElement(By.id("city")).sendKeys(fakeCity);
     driver.findElement(By.id("zipcode")).sendKeys(fakeZipCode);
     driver.findElement(By.id("mobile_number")).sendKeys(fakePhoneNumber);

     // 13. Click 'Create Account button'
     WebElement createAccountButton = explicitlyWaitFor_xPath("//*[@data-qa='create-account']",30);
     clickByJS(createAccountButton);
     // 14. Verify that 'ACCOUNT CREATED!' is visible
     boolean accountCreated = driver.findElement(By.xpath("//b")).isDisplayed();
     Assert.assertTrue(accountCreated);
        waitFor(2000);

     // 15. Click 'Continue' button
     WebElement continueButton = driver.findElement(By.partialLinkText("Continue"));
     clickByJS(continueButton);

     // 16. Verify that 'Logged in as username' is visible
        waitFor(2000);

        //  ***********************************  ATTENTION PLEASE **************************************
        //There are two type iframes appear randomly: I cannot be able to handle by Automation. I closed by manually
        /*
         Actions actions =  new Actions(driver);
         waitFor(3000);
         actions.moveByOffset(35,18).click().build().perform(); // (35,18) -- (115,35)
         // iframe id="aswift_2"    ,     iframe id="ad_iframe"    ,

        */




        // **********************************************************************************************

        WebElement loggedInAsElement = explicitlyWaitFor_xPath("//a[text()=' Logged in as ']",5);
        String loggedInAs =loggedInAsElement.getText();
        System.out.println("loggedInAs = " + loggedInAs);
        waitFor(3000);

     // 17. Click 'Delete Account' button

        WebElement deleteAccountButton = explicitlyWaitFor_xPath("//a[@href='/delete_account'])",5);
        clickByJS(deleteAccountButton);
        System.out.println(driver.getTitle());
     // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     Assert.assertTrue(explicitlyWaitFor_xPath("//*[text()='Account Deleted!']",3).isDisplayed());
     explicitlyWaitFor_xPath("//a[@data-qa='continue-button']",3).click();

    }

}
