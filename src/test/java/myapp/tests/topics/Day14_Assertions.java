package myapp.tests.topics;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Day14_Assertions {
    @Test
    public void hardAssertion(){
        /*
        HARD ASSERTION : if hard assertion fails, then STOP execution for that test case
         */
        System.out.println("line 8");
        assertTrue(true); //PASS so it continues
        System.out.println("line 12");
        assertEquals("apples", "oranges"); //FAIL so it stops
        System.out.println("line 15");
    }
    @Test
    public void softAssertion(){
         /*
        SOFT ASSERT : if soft assertion fails, then CONTINUE execution for that test case
         */
        System.out.println("line 19");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(true); //PASS so it continues
        System.out.println("lline 23");
        softAssert.assertEquals("apples", "oranges"); //FAIL but it continues
        System.out.println("line 25");
        softAssert.assertAll("Test assertion completed"); //assertAll must be used for a correct test result
    }
    @Test
    public void javaAssertion(){
         /*
        java assertions are hard assertions. if assert fails then STOPS
        We should prefer to use TestNG assertions
        if java assertion fails, then STOP execution for that test case
         */
        System.out.println("line 35");
        assert 3<5; //Same as: If (3<5). If assertion TRUE then continue, otherwise throws java.lang.AssertionError
        System.out.println("line 37");
        assert "apples"=="apples";
        assert "apples".toLowerCase().contains("e");
    }
}
