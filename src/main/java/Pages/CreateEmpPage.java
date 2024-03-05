package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateEmpPage extends BasePage {

    public CreateEmpPage(WebDriver driver) {
        super(driver);
    }
    WebElement employes() {
        return driver.findElement(By.xpath("//a[@class='btn btn-primary btn-lg btn-block text-wrap home-buttons']"));
    }
    WebElement createEmployes() {
        return driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm mb-3 bottom-margin']"));
    }
    WebElement title() {
        return driver.findElement(By.xpath("//select[@id='title']"));
    }
    WebElement empFirstName(){
        return driver.findElement(By.xpath("//input[@id='firstName']"));
    }
    WebElement empLastName(){
        return driver.findElement(By.xpath("//input[@id='lastName']"));
    }
    WebElement empEmail(){
        return driver.findElement(By.xpath("//input[@id='email']"));
    }
    WebElement empPosition(){
        return driver.findElement(By.xpath("//input[@id='positionApplied']"));
    }
    WebElement empReferenceNo(){
        return driver.findElement(By.xpath("//input[@id='referenceNumber']"));
    }
    WebElement createEmployee() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
    WebElement createEmpMsgDisplay() {
        return driver.findElement(By.xpath("/html/body/div/div[2]/div[1]"));
    }
    public void clickEmployee() {
        employes().click();
    }
    public void clickCreateEmployee() {
        createEmployes().click();
    }
    public void clickTittle() {
        title().click();
    }
    public void selectTitleByIndex(int index) {
        WebElement titleDropdown = driver.findElement(By.xpath("//select[@id='title']"));
        Select dropdown = new Select(titleDropdown);
        dropdown.selectByIndex(index);
    }
    public void clickCreateEmpButton() {
        createEmployee().click();
    }
    public void setEmpFirstName(String empFirstName) {
        empFirstName().sendKeys(empFirstName);
    }
    public void setEmpLastName(String EmpLastName) {
        empLastName().sendKeys(EmpLastName);
    }
    public void setEmpEmail(String empEmail) {
        empEmail().sendKeys(empEmail);
    }
    public void setEmpPosition(String empPosition) {
        empPosition().sendKeys(empPosition);
    }
    public void setEmpReference(String empReferenceNo) {
        empReferenceNo().sendKeys(empReferenceNo);
    }
    public boolean checkCreateEmpMsgDisplay() {
        try {
            return createEmpMsgDisplay().isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
    public boolean isWarningMessageDisplayed() {
        try {
            WebElement warningMessage = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div/text()"));
            return warningMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    //Checking create employee page actions
    WebElement persionalDetails(){
        return driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/a[1]"));
    }
    public void clickPD(){
        persionalDetails().click();
    }
    WebElement psBackButton(){
        return driver.findElement(By.xpath("//a[@class='btn btn-info']"));
    }
    public void clickpsBackButton(){
        psBackButton().click();
    }
    WebElement resetPassword(){
        return driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(4) div:nth-child(1) a:nth-child(2)"));
    }
    public void clickResetPassword() {
        resetPassword().click();
    }
    WebElement resetPasswordBack(){
        return driver.findElement(By.xpath("//a[@class='btn btn-info']"));
    }
    public void clickResetPasswordBack() {
        resetPasswordBack().click();
    }
    WebElement lockUnlock(){
        return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/form[1]/button[1]"));
    }
    public void clickLockUnlock(){
        lockUnlock().click();
    }
    public boolean isLUWarningMessageDisplayed() {
        try {
            WebElement warningMessage = driver.findElement(By.xpath("//div[@role='alert']"));
            return warningMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    WebElement delete(){
        return driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/a[3]"));
    }
    public void clickDelete(){
        delete().click();
    }
}
