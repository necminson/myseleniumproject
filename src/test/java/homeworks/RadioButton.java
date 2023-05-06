package homeworks;

import com.github.javafaker.*;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RadioButton extends TestBase {

    Faker obj = new Faker();
    @Test
    public void RadioButton(){
        // Go to https://www.facebook.com/
        driver.get("https://www.facebook.com");
        //  Click on Create an Account button
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        /*
        Locate the elements of radio buttons
        Then click on the radio buttons for your gender if they are not selected
        */
        WebElement maleElement= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        maleElement.click();


        //Enter first name and last name
       String firstName = obj.name().firstName();
       String lastName = obj.name().lastName();
       driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
       driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
       //Enter mobile number or email
       String phoneNumber = obj.phoneNumber().cellPhone();
       driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(phoneNumber);
       // Enter new password
       String password = obj.internet().password();
       driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(password);
       // Enter birthday(LATER)
        // day
       WebElement days = driver.findElement(By.xpath("//select[@id='day']"));
       Select optionDays = new Select(days);
       optionDays.selectByVisibleText("6");

        // month
        WebElement months = driver.findElement(By.xpath("//select[@id='month']"));
        Select optionMonths = new Select(months);
        optionMonths.selectByValue("10");

        // year
        WebElement years = driver.findElement(By.xpath("//select[@id='year']"));
        Select optionYears = new Select(years);
        optionYears.selectByVisibleText("1971");

       // Click Sign Up
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

    }
}


