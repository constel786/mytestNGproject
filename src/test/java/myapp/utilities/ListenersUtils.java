package myapp.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersUtils implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {
//    1. In utilities package, create a ListenersUtil class
//    Listeners class has all ITestListeners methods.
//    And implements ITestListeners interface.
//            2. Implement ITestListener
//3. Add the ITestListener Methods
//4. In tests package, create a new package : listeners
//5. In listeners package, create a new java class : ListenersTest1
//6. There are 2 ways to connect Listeners and Test Classes
//    a. Use this in the test class :
//    @Listeners(techproed.utilities.Listeners.class)
//    b. Add listeners tag before test in the xml file to connect Listeners and this xml file
//<listeners>
//    <listener class-name="techproed.utilities.Listeners"></listener>
//</listeners>

    @Override
    public void onStart(ITestContext context) { //Similar to @BeforeSuite
        System.out.println("onStart: executes ONCE before ALL test cases (@Test): " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) { //Similar to @AfterSuite
        System.out.println("onFinish: executes ONCE after ALL test cases (@Test): " + context.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart: executes ONCE before EACH test case (@Test): " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess: executes ONCE after EACH passing test case (@Test): " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped: executes ONCE after EACH skipped/ignored test case (@Test): " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        System.out.println("onTestSFailure : executes ONCE AFTER EACH FAILED test cases(@Test) : " +result.getName());
//        Capturing screenshot for failed test cases automatically
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    Rerun Failed Test Cases automatically one more time
//    IRetryAnalyzer Method Is Implemented
//    This method will be called automatically to RETRY THE FAILED TEST CASES
    private int retryCount = 0;
    private static final int maxRetryCount = 1;//RERUN COUNT
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
//    IAnnotationTransformer method is added
//    This makes the failed test cases automatically rerun using testng xml files
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(ListenersUtils.class);
    }
}