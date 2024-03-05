package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
}

    WebElement username() {
        return driver.findElement(By.xpath("//input[@placeholder='Email']"));
    }
    WebElement password(){
    return driver.findElement(By.xpath("//input[@placeholder='Password']"));
    }
    WebElement loginbutton(){
    return  driver.findElement(By.xpath("//button[normalize-space()='Login']"));
    }

    public void setuserName(String username) {
        username().sendKeys(username);
    }
    public  void setPassword(String password){
    password().sendKeys(password);
    }
    public void Clicklogin(){
        loginbutton().click();
}

    }

