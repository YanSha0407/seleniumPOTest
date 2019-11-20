package selenium.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.rmi.server.ExportException;
import java.util.List;

public class ContactPage extends BasePage {
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
    /*
    删除成员
     */
    public ContactPage delect(String userID){
        findElement(By.id("memberSearchInput")).sendKeys(userID);
        try {
            visibilityWait(By.linkText("编辑"));
        }catch (Exception e) {
            System.out.println("没找到元素");
            return this;
        }
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
        findElement(By.id("clearMemberSearchInput")).click();
        findElement(By.id("memberSearchInput")).clear();
        return this;
    }

    /*
     删除当前页全部成员
    */
    public ContactPage delectCurrentPage(){
        visibilityWait(By.cssSelector(".ww_checkbox"));
        List<WebElement> list = driver.findElements(By.cssSelector(".ww_checkbox"));
        System.out.println("++++++++++" + list.size());
        for (int i = 2 ;i< list.size();i++){
            list.get(i).click();
            try {
                Thread.sleep(500);
            }
            catch (Exception e){
                 e.printStackTrace();
            }
        }
        findElement(By.linkText("删除")).click();
        findElement(By.linkText("确认")).click();
//        visibilityWait(By.cssSelector(".ww_checkbox"));
//        findElement(By.cssSelector(".ww_checkbox")).click();
//        findElement(By.linkText("删除")).click();
//        findElement(By.linkText("确认")).click();
        return this;
    }

}
