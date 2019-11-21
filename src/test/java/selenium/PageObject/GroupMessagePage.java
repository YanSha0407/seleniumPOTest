package selenium.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;

public class GroupMessagePage extends BasePage{

    public GroupMessagePage groupMessage(String user,String title,String body,String summary,String author){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElement(By.linkText("管理工具")).click();
        findElement(By.cssSelector(".ww_icon_AppGroupMessageBig")).click();
        findElement(By.linkText("选择需要发消息的应用")).click();
        findElement(By.cssSelector(".ww_icon_AppNotice")).click();
        findElement(By.linkText("确定")).click();
        findElement(By.linkText("选择发送范围")).click();
        findElement(By.id("memberSearchInput")).sendKeys(user);
        findElement(By.cssSelector(".ww_searchResult_title_peopleName")).click();
        findElement(By.linkText("确认")).click();
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);
        System.out.println(driver.getWindowHandles());
        driver.switchTo().frame(1);
        findElement(By.cssSelector(".msg_noticeEditor_frameBody")).sendKeys(body);
        driver.switchTo().defaultContent();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,1000)");
        findElement(By.cssSelector(".msg_edit_infoItem_textWord")).click();
        findElement(By.cssSelector(".qui_textarea")).sendKeys(summary);
        findElement(By.cssSelector(".js_amrd_sendName")).sendKeys(author);
        try{
            Thread.sleep(5000);
            findElement(By.linkText("发送")).click();
        }
        catch (Exception e){
            System.out.println("没找到元素");
        }
        findElement(By.linkText("确定")).click();
        return this;
    }

}



