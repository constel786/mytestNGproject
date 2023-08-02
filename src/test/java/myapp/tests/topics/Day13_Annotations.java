package myapp.tests.topics;

import org.testng.annotations.*;

public class Day13_Annotations {
//    @Test: creates test case
//    @Before and @After: there are 5 Before and 5 After
//    Hierarchy: suite > test > group > class > method
//    @Ignore: Skip / Ignore the test cases
//    @Test(enable=false): disables the test cases
//    @Test(priority=priority number): prioritizes test cases
//    By default, TestNG runs in alphabetical order-NOT FROM TOP TO BOTTOM

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method...");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class...");
    }
    @BeforeGroups
    public void beforeGroups(){
        System.out.println("Before groups...");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test...");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before suite...");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method...");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class...");
    }
    @AfterGroups
    public void afterGroups(){
        System.out.println("After groups...");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After test...");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite...");
    }
    @Test
    public void test1(){
        System.out.println("Test1");
    }
    @Test
    public void test2(){
        System.out.println("Test2");
    }
    @Test
    public void test3(){
        System.out.println("Test3");
    }
    @Test
    public void test4(){
        System.out.println("Test4");
    }
    @Test
    public void test5(){
        System.out.println("Test5");
    }
}
