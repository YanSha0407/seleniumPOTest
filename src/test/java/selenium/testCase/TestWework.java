package selenium.testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import selenium.PageObject.App;

public class TestWework {

    public App app;
    @Before
    public void setUp(){
         app = new App();
         app.setUpCookie();
    }
    @After
    public  void teardown(){

    }
    @Test
    public  void  demo(){
//         app.toContact().list();
         String name = "13001277119";
         app.toMemberAdd().add(name,name,name);
    }
}
