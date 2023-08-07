package myapp.tests.topics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day14_DependsOnMethods {

    @Test
    public void homePage(){
        System.out.println("Home Page Test");
    }
    @Test
    public void searchTest(){
        System.out.println("Search Test");
        Assert.assertTrue(false); //FAILS
    }
    @Test(dependsOnMethods = "searchTest") //If searchTest PASSES then checkOutTest executes
                                           //If searchTest FAILS then checkOutTest will be ignored
    public void checkOutTest(){
        System.out.println("Check Out Test");
    }
}
