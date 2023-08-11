package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestFormPage {

    public RequestFormPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "first_name")
    public WebElement firstnameInput;

    @FindBy(name = "last_name")
    public WebElement lastnameInput;

    @FindBy(name = "business_name")
    public WebElement businessNameInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(id = "numb1")
    public WebElement numb1;

    @FindBy(id = "numb2")
    public WebElement numb2;

    @FindBy(id = "number")
    public WebElement resultInput;

    @FindBy(id = "demo")
    public WebElement submitButton;

    @FindBy(xpath = "//p[@class='text-center cw']")
    public WebElement successMessage;


}
