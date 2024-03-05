package Tests;

import Pages.LoginPage;
import org.testng.annotations.Test;

public class Test_003 extends BaseClass {


    @Test(groups = {"sanity","master"})
    public void test3(){
        LoginPage bc = new LoginPage(driver);
        bc.setuserName("skilledems@gmail.com");
        bc.setPassword("admin");
        bc.Clicklogin();
    }

}
