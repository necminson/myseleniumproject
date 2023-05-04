package com.myfirstproject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Day05_Checkbox {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void checkboxTest() {
//        Then click on checkbox1 if box is not selected
        //locating the element by xpath
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='box1']"));
        //is checkbox 1 is already selected
        boolean isCheckbox1Selected = checkbox1.isSelected();
        // ! = NOT
        if (!isCheckbox1Selected) {
            checkbox1.click();
        }
//        Then click on checkbox2 if box is not selected
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='box2']"));
        //is checkbox 2 is already selected
        boolean isCheckbox2Selected = checkbox2.isSelected();
        // ! = NOT
        if (!isCheckbox2Selected) {
            checkbox2.click();
//        Then verify that checkbox1 is checked
            Assert.assertTrue(checkbox1.isSelected());//PASS is checkbox1 is selected. FAILS if checkbox1 is NOT selected
        }
    }
}