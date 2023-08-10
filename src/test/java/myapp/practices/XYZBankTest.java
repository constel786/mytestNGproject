package myapp.practices;

import com.github.javafaker.Faker;
import myapp.pages.XYZBankCustomerPage;
import myapp.pages.XYZBankHomePage;
import myapp.pages.XYZBankManagerPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class XYZBankTest {
    //Open 5 new  Accounts, deposit 100 USD and withdraw 100 USD from one of them and delete all accounts you created.
 /*
Given
    Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
When
    Click on "Bank Manager Login" button
And
    Click on "Add Customer" button
And
    Fill inputs and click on "Add Customer" submit button
And
    Accept alert
And
    Add 4 more customers
And
    Click on "Open Account"  button
And
    Click on "Customer" dropdown
And
    Select customer name
And
    Click on "Currency" dropdown
And
    Select "Dollar"
And
    Click on "Process" button
And
    Accept alert
And
    Open 4 more accounts
And
    Click on "Customers" button
And
    Count table row numbers
Then
    Assert that you created 5 customers
When
    Click on "Home" button
And
    Click on "Customer Login" button
And
    Click on "Your Name" dropdown
And
    Select the any name you created
And
    Click on "Login" button
And
    Click on "Deposit" button
And
    Type 100 into "Amount to be Deposited" input
And
    Click on "Deposit"(Submit) button
Then
    Assert that "Deposit Successful" is displayed
And
    Click on "Withdrawal" button
And
    Type 100 into "Amount to be Withdrawn" input
And
    Click on "Withdraw"(Submit) button
Then
    Assert that "Transaction  Successful" is displayed
When
    Click on "Logout" button
And
    Click on "Home" button
And
    Click on "Bank Manager Login" button
And
    Click on "Customers" button
And
    Click on each "Delete" button
And
    Count table row numbers
Then
    Assert that number of customers is 0

 */

    @Test
    public void xyzBank() {
//        Go to url https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
        Driver.getDriver().get(ConfigReader.getProperty("xyz_bank_url"));

//        Click on "Bank Manager Login" button
        XYZBankHomePage xyzBankHomePage = new XYZBankHomePage();
        xyzBankHomePage.bankManagerLoginButton.click();

//        Click on "Add Customer" button
        XYZBankManagerPage xyzBankManagerPage = new XYZBankManagerPage();
        xyzBankManagerPage.addCustomerButton.click();


//        Fill inputs and click on "Add Customer" submit button
        Faker faker = new Faker();
        for (int i=0; i<5; i++){//This loop will work for 5 times
            xyzBankManagerPage.firstnameInput.sendKeys(faker.name().firstName());
            xyzBankManagerPage.lastnameInput.sendKeys(faker.name().lastName());
            xyzBankManagerPage.postCodeInput.sendKeys(faker.address().zipCode());
            xyzBankManagerPage.addCustomerSubmitButton.click();

//        Accept alert
            Driver.getDriver().switchTo().alert().accept();

            //        Add 4 more customers
        }


//        Click on "Open Account"  button
        xyzBankManagerPage.openAccountButton.click();

//        Select customer name
        Select selectCustomer = new Select(xyzBankManagerPage.customerDD);
        Select selectCurrency = new Select(xyzBankManagerPage.currencyDD);


        for(int i=0; i<5; i++){

            selectCustomer.selectByIndex(6+i);
//        Select "Dollar"
            selectCurrency.selectByIndex(1);
//        Click on "Process" button
            xyzBankManagerPage.processButton.click();
//        Accept alert
            Driver.getDriver().switchTo().alert().accept();

            //        Open 4 more accounts

        }


//        Click on "Customers" button
        xyzBankManagerPage.customersButton.click();


//        Assert that you created 5 customers

        for (int i=0; i<5; i++){

            assertEquals(1016+i, Integer.parseInt(xyzBankManagerPage.accountNumberList.get(5+i).getText()));

        }

//        Click on "Home" button
        xyzBankHomePage.homeButton.click();

//        Click on "Customer Login" button
        xyzBankHomePage.customerLoginButton.click();


//        Select  any name you created
        XYZBankCustomerPage xyzBankCustomerPage = new XYZBankCustomerPage();
        new Select(xyzBankCustomerPage.yourNameDD).selectByIndex(6);

//        Click on "Login" button
        xyzBankCustomerPage.loginButton.click();

//        Click on "Deposit" button
        xyzBankCustomerPage.depositButton.click();

//        Type 100 into "Amount to be Deposited" input
        xyzBankCustomerPage.amountInput.sendKeys("100");

//        Click on "Deposit"(Submit) button
        xyzBankCustomerPage.depositSubmitButton.click();

//        Assert that "Deposit Successful" is displayed
        assertTrue(xyzBankCustomerPage.depositSuccessMessage.isDisplayed());
        assertEquals("Deposit Successful", xyzBankCustomerPage.depositSuccessMessage.getText() );

//        Click on "Withdrawal" button
        xyzBankCustomerPage.withDrawlButton.click();

//        Type 100 into "Amount to be Withdrawn" input
        xyzBankCustomerPage.withdrawSubmitButton.click();//First we click on submit to activate the input
        xyzBankCustomerPage.withdrawAmountInput.sendKeys("100");
//
//        Click on "Withdraw"(Submit) button
        xyzBankCustomerPage.withdrawSubmitButton.click();

//        Assert that "Transaction  Successful" is displayed
        assertTrue(xyzBankCustomerPage.withdrawSuccessMessage.isDisplayed());

//        Click on "Logout" button
        xyzBankCustomerPage.logoutButton.click();

//        Click on "Home" button
        xyzBankHomePage.homeButton.click();

//        Click on "Bank Manager Login" button
        xyzBankHomePage.bankManagerLoginButton.click();

//        Click on "Customers" button
        xyzBankManagerPage.customersButton.click();

//        Click on each "Delete" button
        xyzBankManagerPage.deleteButtonList.forEach(WebElement::click);

//        Assert that number of customers is 0
        assertTrue(xyzBankManagerPage.deleteButtonList.isEmpty());
    }
}
