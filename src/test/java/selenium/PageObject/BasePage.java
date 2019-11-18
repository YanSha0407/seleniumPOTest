package selenium.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
      protected static WebDriver driver;
      protected WebElement findElement(By by){
          return App.driver.findElement(by);
      }
}
