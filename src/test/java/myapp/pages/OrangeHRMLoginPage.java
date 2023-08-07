package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class OrangeHRMLoginPage {
    /*
    1. Constructor with PageFactory.initElements(driver,this); to instantiate the element
    2. Locate elements using @FindBy annotation
    This page classes are also known as 'page repository' or 'object repository'
     */
    public OrangeHRMLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this); //instantiate the page objects
    }
//  public WebElement username = driver.findElement(By.name("username"));
//  @FindBy(name = "username") = public WebElement username;
    @FindBy(name = "username")
    public WebElement username;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
}
