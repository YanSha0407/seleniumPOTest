package selenium.testCase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import selenium.PageObject.App;
import selenium.PageObject.GroupMessagePage;

public class TestGroupMessage {
    public static App app;
    @BeforeClass
    public static void beforeAll(){
        app = new App();
        app.setUpCookie();
    }
    @Test
    public void groupMessage(){
        GroupMessagePage groupMessagePage = new GroupMessagePage();
        groupMessagePage.groupMessage("LOFTER","快来取快递了","赵福文你的快递已到，请注意查收","快递到了","燕莎");
    }
    @AfterClass
    public static void  afterAll(){
        try {
            app.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
