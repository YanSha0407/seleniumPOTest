package selenium.testCase;

import org.junit.*;
import selenium.PageObject.App;

import java.security.PublicKey;

public class TestWework {

    public static App app;
    @BeforeClass
    public static void setUp(){
         app = new App();
         app.setUpCookie();

    }
    /*
    添加成员
     */
    @Test
    public  void  add(){
//         app.toContact().list();
         String name = "13001277113";
         app.toContact().delect(name);
         app.toMemberAdd().add(name,name,name);
    }
    /*
    删除成员
     */
    @Test
    public void delect(){
        String userID = "13001277110";
        app.toMemberAdd().add(userID,userID,userID).delect(userID);
    }
    @Test
        /*
    删除当前页全部成员
     */
    public void delectCurrentPage(){
         app.toContact().delectCurrentPage();
    }

    /*
     禁用当前用户
     */
    @Test
    public void forbiddenUser(){
        app.toContact().forbiddenUser();
    }
    /*
    编辑当前用户
     */
    @Test
    public void editUser(){
        app.toContact().editUser();
    }
    /*
    取消置顶
     */
    @Test
    public void alwaysTop(){
        app.toContact().alwaysTop();
    }
    /*
    设置员工所在部门
     */
    @Test
    public void employeeDepartment(){
        app.toContact().employeeDepartment();
    }
    @AfterClass
    public static void afterAll() throws InterruptedException {
        app.quit();
    }
}
