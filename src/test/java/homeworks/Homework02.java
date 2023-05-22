package homeworks;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.myfirstproject.utilities.ReusableMethodsUtils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Homework02 extends TestBase {
                //Task04:

        @Test
    public void task04Test(){

    //-Go to http://demo.automationtesting.in/Alerts.html
      driver.get("http://demo.automationtesting.in/Alerts.html");
    //-Click the button "click the button to display an alert box:" opposite "Alert with OK"
      driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
    //-Print the text on the alert to the console and click the "OK" button.
      Alert alert01 = driver.switchTo().alert();
            System.out.println("alertText = " + alert01.getText());
            alert01.accept();

    //-Click the "Alert with OK & Cancel" button and then click the "Click the button to display a confirm box"
            explicitlyWaitFor_xPath("//a[@href='#CancelTab']",5).click();
            explicitlyWaitFor_xPath("//button[@onclick='confirmbox()']",5).click();
    //-Press the "cancel" button in the alert

      Alert alert02 = driver.switchTo().alert();
      alert02.dismiss();
    //-Assert "You Pressed Cancel" text is displayed
            String textAfterCancel= driver.findElement(By.xpath("//p[@id='demo']")).getText();
            assertEquals("actualData & expectedData did not match","You Pressed Cancel",textAfterCancel);
    //-Click the "Alert with Textbox" button and then click the "Click the button to demonstrate the prompt box"
            explicitlyWaitFor_xPath("//a[@href='#Textbox']",5).click();
            explicitlyWaitFor_xPath("//button[@onclick='promptbox()']",5).click();
    //-Write your 'name' in the prompt box and click "OK"
            waitFor(3000);
            Alert alertText03 = driver.switchTo().alert();
            alertText03.sendKeys("necminson");
            alertText03.accept();
    //-Print the message to console
            String message= driver.findElement(By.xpath("//p[@id='demo1']")).getText();
            System.out.println("message = " + message);
    //-Verify that the message is 'Hello <your name> How are you today'
            assertEquals("actualMessage & expectedMessage did not match","Hello necminson How are you today",message);
        }


    // **************************************


    //Task05:

        @Test
    public void task05Test(){

    // Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
    // Click on the "Animals and Nature" emoji
        driver.switchTo().frame("emoojis");
        WebElement animalsAndNature =  explicitlyWaitFor_xPath("//a[@href='#nature']",5);
        clickByJS(animalsAndNature);
    // Print emojis under "Animals and Nature" emoji
        List<WebElement> natureList = driver.findElements(By.xpath("//div[@id='nature']//div"));
        natureList.forEach(each-> System.out.println(each.getText()));
        driver.switchTo().defaultContent();
    // Fill the form
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("My Emoji Store");
        driver.findElement(By.xpath("//*[@id='smiles']")).sendKeys("Smiling faces");
        driver.findElement(By.xpath("//*[@id='nature']")).sendKeys("Natural Emoji");
        driver.findElement(By.xpath("//*[@id='food']")).sendKeys("Delicious Foods");
        driver.findElement(By.xpath("//*[@id='activities']")).sendKeys("Be Active");
        driver.findElement(By.xpath("//*[@id='places']")).sendKeys("Around Us");
        driver.findElement(By.xpath("//*[@id='objects']")).sendKeys("Objects Emoji");
        driver.findElement(By.xpath("//*[@id='symbols']")).sendKeys("Symbols Emoji");
        driver.findElement(By.xpath("//*[@id='flags']")).sendKeys("Flags Emoji");
        driver.findElement(By.xpath("//*[@id='hide']")).sendKeys("Hidden Emoji");
        driver.findElement(By.xpath("//*[@id='active']")).sendKeys("Smiling faces");

    // Press the apply button
        driver.findElement(By.xpath("//*[@id='send']")).click();
    // Verify "code" element is displayed
        assertTrue(driver.findElement(By.xpath("//*[@id='code']")).isDisplayed());
        }


    //**************************************


    //Task06:

    @Test
    public void task06Test(){
    // Go to http://szimek.github.io/signature_pad/
        driver.get("http://szimek.github.io/signature_pad/");
    // Draw the line or shape you want on the screen
          WebElement canvas = driver.findElement(By.xpath("//canvas"));

           new Actions(driver)
                   .moveToElement(canvas)
                   .clickAndHold()
                   .moveByOffset(150,150)  // Moves to the starting point
                   .moveByOffset(200,200)  // Moves to the terminal point
                   .release()
                   .perform();

        waitFor(2000);
    // Press the clear button after drawing
        WebElement clearButton = driver.findElement(By.xpath("//*[.='Clear']"));
        clearButton.click();

    // Close the page (TestBase @After method closes)
        }
    }
