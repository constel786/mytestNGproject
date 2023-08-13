package myapp.tests.topics;

import myapp.utilities.Driver;
import myapp.utilities.ExtentReportUtils;
import org.testng.annotations.Test;

public class Day14_DriverTest {
    @Test
    public void driverTest(){
        //        driver.get("https://amazon.com");
        //        driver --->>> Driver.getDriver
        ExtentReportUtils.createTestReport("Driver Test", "testing driver");
        ExtentReportUtils.pass("Test case begins");
        Driver.getDriver().get("https://amazon.com");
        ExtentReportUtils.pass("User is on the amazon homepage");
        String amazonTitle = Driver.getDriver().getTitle();
        ExtentReportUtils.pass("Getting the title: " + amazonTitle);
        String amazonURL = Driver.getDriver().getCurrentUrl();
        ExtentReportUtils.pass("Getting the URL: " +amazonURL);
        System.out.println("Title = " + amazonTitle);
        System.out.println("URL = " + amazonURL);
        Driver.closeDriver();
        ExtentReportUtils.pass("Test is completed");
        ExtentReportUtils.flush(); //END
    }
}
