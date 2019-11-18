package selenium.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class ContactPage extends BasePage {
    public WebDriver driver;
    /*
      通讯录列表
     */
    public void list(){

    }
    /*
       加成员
     */
    public ContactPage add(String name,String account, String phoneNum){
        findElement(By.name("username")).sendKeys(name);
        findElement(By.name("acctid")).sendKeys(account);
        findElement(By.name("mobile")).sendKeys(phoneNum);
        findElement(By.xpath("//a[contains(text(),'保存并继续添加')]")).click();
        return this;
    }
}
