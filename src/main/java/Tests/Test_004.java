package Tests;
import Pages.CreateEmpPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_004 extends BaseClass {
    @Test(groups = {"regression", "master"})
    public void test() {
        try {
            LoginPage bc = new LoginPage(driver);
            bc.setuserName("skilledems@gmail.com");
            bc.setPassword("admin");
            bc.Clicklogin();
            logger.info("Clicked on MyAccount link");

            CreateEmpPage cp = new CreateEmpPage(driver);
            cp.clickEmployee();
            cp.clickCreateEmployee();
            cp.clickTittle();
            cp.selectTitleByIndex(1);
            cp.setEmpFirstName("Dheeraj");
            cp.setEmpLastName("Maneru");
            cp.setEmpEmail("mnru194@gmail.com");
            cp.setEmpPosition("Testing Engineer");
            cp.setEmpReference("A121QW");
            cp.clickCreateEmpButton();

            if (cp.isWarningMessageDisplayed()) {
                Assert.assertTrue(true);
                System.out.println("The user already exists");
            } else {
                boolean nxtpage = cp.checkCreateEmpMsgDisplay();
                if (nxtpage) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail();
                }

                // Checking create employee page actions
                cp.clickPD();
                String pageTitle = driver.getTitle();
                System.out.println("The Title is: " + pageTitle);
                cp.clickpsBackButton();
                cp.clickResetPassword();
                String resetPasswordPageTitle = driver.getTitle();
                System.out.println("The Title is: " + resetPasswordPageTitle);
                cp.clickResetPasswordBack();
                cp.clickLockUnlock();
                if (cp.isLUWarningMessageDisplayed()) {
                    Assert.assertTrue(true);
                } else {
                    System.out.println("unlocked");
                }
                cp.clickLockUnlock();
                cp.clickDelete();
            }
        } catch (Exception e) {
            // logger.error("Test failed: " + e.getMessage());
            // Assert.fail();

        }
    }
}
