package selenium.testCase;

import org.junit.*;
import selenium.PageObject.App;

public class TestWework {

    public static App app;
    @BeforeClass
    public static void setUp(){
         app = new App();
         app.setUpCookie();

    }
    @Test
    public  void  add(){
//         app.toContact().list();
         String name = "13001277113";
         app.toContact().delect(name);
         app.toMemberAdd().add(name,name,name);
    }

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
    @AfterClass
    public static void afterAll() throws InterruptedException {
          app.quit();
    }
}
