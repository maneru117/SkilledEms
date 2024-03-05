package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataProviders;

public class Test_002 extends BaseClass {
    protected WebDriver driver;
    @Test(dataProvider="LoginData",dataProviderClass= DataProviders.class)

    public void Logintest(String email, String password, String exp) {
        try{
        LoginPage bc = new LoginPage(driver);
        bc.setuserName("skilledems@gmail.com");
        bc.setPassword("admin");
        bc.Clicklogin();
            HomePage hm= new HomePage(driver);
            boolean HomePage=hm.checkHomePageDisplay();
        if(exp.equalsIgnoreCase("Valid"))
        {
            if(HomePage==true)
            {
               hm.ClickLogout();
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
        }

        if(exp.equalsIgnoreCase("Invalid"))
        {
            if(HomePage==true)
            {
                hm.ClickLogout();
                Assert.assertTrue(false);
            }
            else
            {
                Assert.assertTrue(true);
            }
        }
    }
		catch(Exception e)
    {
        Assert.fail("An exception occurred: " + e.getMessage());
    }

    }

}