package selenium.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class App extends BasePage{

    /*
    初始化cookie
     */
    public void setUpCookie(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new FirefoxDriver();
        String url = "http://work.weixin.qq.com";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1406,877));
        driver.findElement(By.className("index_top_operation_loginBtn")).click();
        driver.manage().addCookie(new Cookie("wwrtx.refid","42775325302744230"));
        driver.manage().addCookie(new Cookie("wwrtx.sid","7DChPLO4PDZGxu7jcuS4CriMcQmWMeceTnldIelcBrlOHalnYhqGRGL0kV0A43tO"));
        driver.navigate().refresh();
    }
    /*
      打开通讯录
     */
    public ContactPage toContact(){
         driver.findElement(By.partialLinkText("通讯录")).click();
         return new ContactPage();
    }
    /*
       打开添加成员界面
     */
    public ContactPage toMemberAdd(){
        driver.findElement(By.linkText("添加成员")).click();
        return new ContactPage();
    }
}
