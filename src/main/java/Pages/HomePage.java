package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    WebElement Head() {
        return driver.findElement(By.xpath("//p[@class='text-success']"));
    }
    WebElement Logout(){
        return driver.findElement(By.xpath("//a[@class='nav-link'][normalize-space()='Logout']"));
    }
    public boolean checkHomePageDisplay() {
        try {
            return Head().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void ClickLogout(){
        Logout().click();
}
}
