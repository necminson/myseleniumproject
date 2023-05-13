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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.myfirstproject.utilities.ThreadSleepUtil.waitUpTo;

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
    driver.findElement(By.xpath("//*[@href='/login']")).click();
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
    driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

    // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    boolean enterAccInfo = driver.findElement(By.xpath("//b")).isDisplayed();
    Assert.assertTrue(enterAccInfo);


    // 9. Fill details: Title, Name, Email, Password, Date of birth
    driver.findElement(By.id("id_gender1")).click();
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
     driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();

     // 14. Verify that 'ACCOUNT CREATED!' is visible
     boolean accountCreated = driver.findElement(By.xpath("//b")).isDisplayed();
     Assert.assertTrue(accountCreated);
        waitUpTo(2000);

     // 15. Click 'Continue' button
     driver.findElement(By.partialLinkText("Continue")).click();


     // 16. Verify that 'Logged in as username' is visible
        waitUpTo(2000);


        //There are two type iframes appear randomly:
/*
         if(driver.getCurrentUrl().contains("#google_vignette")){
             try {
                 Actions actions = new Actions(driver);
                 actions.click(driver.findElement(By.xpath("//div[@id='dismiss-button']")));

             } catch (Exception e) {
                 throw new RuntimeException(e);

             }
         }


 */ //.switchTo().frame("ad_iframe")
        List<String> frames = new ArrayList<>();
        frames.add("aswift_2");
        frames.add("aswift_3");
        for ( String fName: frames) {
            if (fName.equals("aswift_2")){
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aswift_2")));
                driver.switchTo().frame(fName).switchTo().frame("ad_iframe");
                driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
                    driver.switchTo().defaultContent();

            } else if (fName.equals("aswift_3")) {
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aswift_3")));
                driver.switchTo().frame(fName).switchTo().frame("ad_iframe");
                driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
                driver.switchTo().defaultContent();

            }
            else {
                System.out.println("Advertisement does not exist");
                   break;
            }
        }

        WebElement loggedInAsElement = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        String loggedInAs =loggedInAsElement.getText();
        System.out.println("loggedInAs = " + loggedInAs);


        waitUpTo(3000);

     // 17. Click 'Delete Account' button
     driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

     // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
     driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();


    }

}
