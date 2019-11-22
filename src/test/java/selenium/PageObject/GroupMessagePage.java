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
        // 坑1 JS执行时间太长 使用pageLoad策略 设置成NONE
        findElement(By.linkText("选择发送范围")).click();
        findElement(By.id("memberSearchInput")).sendKeys(user);
        findElement(By.cssSelector(".ww_searchResult_title_peopleName")).click();
        findElement(By.linkText("确认")).click();
        findElement(By.cssSelector(".ww_editorTitle")).sendKeys(title);
        System.out.println(driver.getWindowHandles());
        // 坑2 页面中有多个frame 需要切换frame
        driver.switchTo().frame(1);
        findElement(By.cssSelector(".msg_noticeEditor_frameBody")).sendKeys(body);
        // 坑3 找到元素之后还需切换到原来的frame中
        driver.switchTo().defaultContent();
        // 坑4 页面中的元素是否实在可见的范围之内，如果不在需要滚动屏幕 是元素可见
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,1000)");
        findElement(By.cssSelector(".msg_edit_infoItem_textWord")).click();
        findElement(By.cssSelector(".qui_textarea")).sendKeys(summary);
        findElement(By.cssSelector(".js_amrd_sendName")).sendKeys(author);
        // 坑5 页面中定位找到多个元素（如发送按钮一个悬浮 一个在页面最下边）需要再次滚动屏幕是下边发送按钮处于可见状态
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,1000)");
//        try{
//            Thread.sleep(5000);
            findElement(By.linkText("发送")).click();
//        }
//        catch (Exception e){
//            System.out.println("没找到元素");
//        }
        findElement(By.linkText("确定")).click();
        return this;
    }

}



