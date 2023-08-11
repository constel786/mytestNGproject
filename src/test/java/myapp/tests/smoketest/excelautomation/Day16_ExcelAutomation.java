package myapp.tests.smoketest.excelautomation;

import myapp.pages.RentalHomePage;
import myapp.pages.RentalLoginPage;
import myapp.utilities.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day16_ExcelAutomation {
    ExcelUtils excelUtils;
    List<Map<String, String>> dataList;
    RentalHomePage rentalHomePage;
    RentalLoginPage rentalLoginPage;

    @Test
    public void appLoginTest() {
        String path = "resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";

        excelUtils = new ExcelUtils(path, sheetName);
        dataList = excelUtils.getDataList();//getting the data as List<Map>
        System.out.println("dataList = " + dataList);//[{password=c!fas_art, username=sam.walker@bluerentalcars.com}, {password=tad1$Fas, username=kate.brown@bluerentalcars.com}, {password=v7Hg_va^, username=raj.khan@bluerentalcars.com}, {password=Nga^g6!, username=pam.raymond@bluerentalcars.com}]

        for (Map<String, String> w : dataList) {//getting each map element
            rentalHomePage = new RentalHomePage();
            rentalLoginPage = new RentalLoginPage();
            Driver.getDriver().get(ConfigReader.getProperty("bluerentalcar_url"));
            rentalHomePage.loginLink.click();
            rentalLoginPage.username.sendKeys(w.get("username"));
            rentalLoginPage.password.sendKeys(w.get("password"));
            rentalLoginPage.loginButton.click();
            WaitUtils.waitFor(2);
            BrowserUtils.verifyElementDisplayed(rentalHomePage.userID);

            //Log out
            rentalHomePage.userID.click();
            rentalHomePage.logOut.click();
            rentalHomePage.OK.click();

            //Verify if page logout
            BrowserUtils.verifyElementDisplayed(rentalHomePage.loginLink);
            WaitUtils.waitFor(2);
            Driver.closeDriver();

        }
    }
}
