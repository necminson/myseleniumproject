package homeworks;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PressShiftButton extends TestBase {

    @Test
    public void shiftButtonTest(){
        // Go to the "http://google.com"
       driver.get("http://google.com");
        // Write "IPHONE X PRICES" on search box (By pushing shift button)
        WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        actions.
                keyDown(searchBox, Keys.SHIFT)
                .sendKeys("iphone X prices   , ")
        // Write "so expensive" on search box (By without pushing shift button)
                .keyUp(searchBox,Keys.SHIFT)
        // press the "enter" button
                .sendKeys("So expensive"+Keys.ENTER)
                .build()
                .perform();

    }
}
