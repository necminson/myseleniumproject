package com.myfirstproject.practises.practise02;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.myfirstproject.utilities.ReusableMethodsUtils.waitFor;

public class Q02_Form_Addition extends TestBase {

    @Test
    public void fillFormTest(){
        //Go to url : https://phptravels.com/demo/
        driver.get("https://phptravels.com/demo/");

        //Fill the form

        driver.findElement(By.name("first_name")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.name("last_name")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.name("business_name")).sendKeys(Faker.instance().name().title());
        driver.findElement(By.name("email")).sendKeys(Faker.instance().internet().emailAddress());

        int num1= Integer.parseInt(driver.findElement(By.id("numb1")).getText());
        int num2= Integer.parseInt(driver.findElement(By.id("numb2")).getText());
        int result =num2+num1;

       driver.findElement(By.id("number")).sendKeys(result+"");
      waitFor(2000);
        //Click on 'SUBMIT'
        driver.findElement(By.id("demo")).click();
        //Assert that the form has been sent
       WebElement signUp =driver.findElement(By.xpath("//h2[@class='text-center cw tac']"));
        Assert.assertTrue(signUp.isDisplayed());
    }





}
