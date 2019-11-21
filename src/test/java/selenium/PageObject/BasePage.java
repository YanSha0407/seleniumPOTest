package selenium.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
      protected static WebDriver driver;
      protected WebElement findElement(By by){
          return findElement(by,5);
      }
      protected WebElement findElement(By by , int timeOut){
          if (timeOut > 0){
              visibilityWait(by,timeOut);
          }
          return App.driver.findElement(by);
      }
      protected void visibilityWait( By by){
           new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(by));
           new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(by));
      }
      protected void visibilityWait( By by,int timeOut){
        new WebDriverWait(driver,timeOut).until(ExpectedConditions.visibilityOfElementLocated(by));
        new WebDriverWait(driver,timeOut).until(ExpectedConditions.elementToBeClickable(by));
      }
      protected void elementIsExitWait( By by){
           new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(by));
      }
      public void quit() throws InterruptedException {
           Thread.sleep(5000);
           driver.quit();
      }
}
