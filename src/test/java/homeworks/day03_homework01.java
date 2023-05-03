package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class day03_homework01 {
        /*
           Homework : verify if login is successful
           verify if the URL contains "dashboard" keyword
           if URL contains dashboard login is successful or else unsuccessful
        */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void TestVerifyLogin(){
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();
        String actualURL = driver.getCurrentUrl();
        String expectedKeyword = "dashboard";


    /*
        // Verification:
        if (actualURL.contains(expectedKeyword)){
            System.out.println("Test Passed");
        } else{
            System.out.println("Test Failed");
            System.out.println("expectedKeyword = " + expectedKeyword);
            System.out.println("actualURL = " + actualURL);
            System.out.println(actualURL+" does not contain "+expectedKeyword);
        }
     */
        // Assertion
        Assert.assertTrue(actualURL.contains(expectedKeyword));

    }



}
