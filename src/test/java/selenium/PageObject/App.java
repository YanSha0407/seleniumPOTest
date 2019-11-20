package selenium.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class App extends BasePage{

    /*
    初始化cookie
     */
    public void setUpCookie(){
        driver = new FirefoxDriver();
        String url = "http://work.weixin.qq.com";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1406,877));
        driver.findElement(By.className("index_top_operation_loginBtn")).click();
        driver.manage().addCookie(new Cookie("wwrtx.refid","42775325302847881"));
        driver.manage().addCookie(new Cookie("wwrtx.sid","7DChPLO4PDZGxu7jcuS4CmgDEYNxud57Dadn_hseZqK1HDsoV2FdGS1j-EfwiFXP"));
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
