package myapp.practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import myapp.pages.RequestFormPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;


public class Form_Addition {
        /*
   Given
        Go to url : https://phptravels.com/demo/
   When
        Fill the form
   And
        Click on 'SUBMIT'
   Then
        Assert that the form has been sent
    */


    @Test
    public void test01() throws InterruptedException {

//        Go to url : https://phptravels.com/demo/
        Driver.getDriver().get(ConfigReader.getProperty("request_form_url"));

//        Fill the form
        RequestFormPage requestFormPage = new RequestFormPage();

        requestFormPage.firstnameInput.sendKeys("John");
        requestFormPage.lastnameInput.sendKeys("Doe");
        requestFormPage.businessNameInput.sendKeys("QA");
        requestFormPage.emailInput.sendKeys("john@doe.com");

//        Handle the math result
        Thread.sleep(1000);//For the synchronization issue
        int number1 = Integer.parseInt(requestFormPage.numb1.getText());

        Thread.sleep(1000);//For the synchronization issue
        int number2 = Integer.parseInt(requestFormPage.numb2.getText());

        String result = String.valueOf(number1 + number2);
        requestFormPage.resultInput.sendKeys(result);

//        Click on 'SUBMIT'
        requestFormPage.submitButton.click();

//        Assert that the form has been sent
        Thread.sleep(1000);//For the synchronization issue
        String successMessage = requestFormPage.successMessage.getText();
        assertTrue(successMessage.contains("We have sent your demo"));

        Driver.closeDriver();

    }
}
