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
        visibilityWait(By.linkText("立即邀请"));
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

    /*
    禁用当前用户
     */
    public ContactPage forbiddenUser(){
         String name = "13001277113";
         findElement(By.id("memberSearchInput")).sendKeys(name);
         findElement(By.linkText("禁用")).click();
         findElement(By.linkText("确定")).click();
         findElement(By.id("memberSearchInput")).clear();
         return this;
    }

    /*
    编辑当前用户
     */
    public ContactPage editUser(){
         String name = "13001277113";
         String name1 = "13001277118";
         findElement(By.id("memberSearchInput")).sendKeys(name);
         findElement(By.linkText("编辑")).click();
         findElement(By.name("username")).clear();
         findElement(By.name("mobile")).clear();
         findElement(By.name("username")).sendKeys(name1);
         findElement(By.name("mobile")).sendKeys(name1);
         findElement(By.linkText("保存")).click();
         findElement(By.id("memberSearchInput")).clear();
         return this;
    }
    /*
    置顶用户  或取消置顶
     */
    public ContactPage alwaysTop(){
        String name = "13001277118";
        findElement(By.id("memberSearchInput")).sendKeys(name);
        try {
            elementIsExitWait(By.linkText("置顶"));
            findElement(By.linkText("置顶")).click();
        }
        catch (Exception e){
            findElement(By.linkText("取消置顶")).click();
        }
        return this;
    }
    /*
    设置员工所在部门
     */
    public ContactPage employeeDepartment(){
        visibilityWait(By.linkText("立即邀请"));
        visibilityWait(By.cssSelector(".ww_checkbox"));
        String userID = "13001277113";
        List<WebElement> checkBoxlist = driver.findElements(By.cssSelector(".ww_checkbox"));
        List<WebElement> userNamelist = driver.findElements(By.className("member_colRight_memberTable_td"));
        for (int i =0;i < checkBoxlist.size(); i++){
            WebElement element = checkBoxlist.get(i);
            String name = userNamelist.get(i).getText();
            System.out.println("name -------"+name);
            System.out.println("i -------"+i);
            System.out.println("userNamelist-------"+ userNamelist.size());
            System.out.println("checkBoxlist-------"+ checkBoxlist.size());
            if (name.equals(userID)){
               element.click();
               break;
           }
        }
        findElement(By.linkText("设置所在部门")).click();
        findElement(By.cssSelector(".multiPickerDlg_search #memberSearchInput")).sendKeys("Test部门");
        findElement(By.partialLinkText("Test部门")).click();
        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println("没找到元素");
        }

        findElement(By.linkText("确定")).click();
        return this;
    }
}
