package myapp.tests.topics;
import myapp.pages.OrangeHRMDashboardPage;
import myapp.pages.OrangeHRMLoginPage;
import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Day15_OrangeHRMLoginTest {
    /*
    1. located the page objects in the page class
    2. call the page objects in the test classes
    */
    @Test
    public void orangeHRMLoginTest(){
//        Given user is the application login page
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        Then enter the credentials
        OrangeHRMLoginPage orangeHRMLoginPage = new OrangeHRMLoginPage();
        orangeHRMLoginPage.username.sendKeys("Admin");
        orangeHRMLoginPage.password.sendKeys("admin123");
        orangeHRMLoginPage.loginButton.click();
//        Then verify the login is successful
        OrangeHRMDashboardPage orangeHRMDashboardPage = new OrangeHRMDashboardPage();
        Assert.assertTrue(OrangeHRMDashboardPage.profile.isDisplayed());
//        And logout the application
        OrangeHRMDashboardPage.profile.click();
        orangeHRMDashboardPage.logout.click();
//        Then verify the logout is successful
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("auth/login")); //OR
        // Assert.assertTrue(orangeHRMLoginPage.loginButton.isDisplayed());
    }
}