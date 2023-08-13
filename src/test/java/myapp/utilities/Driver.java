package myapp.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ThreadGuard;
import java.time.Duration;
public class Driver {
    //    creating private constructor
    private Driver(){}
    //    creating a thread safe variable. type of the variable is WebDriver.So every thread will have its own copy of the variable
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>(); //driverThreadLocal is simply our driver
    //    getDriver method is used to access the class instance that is WebDriver.
    //    This method will return a copy of the driverThreadLocal for each thread during parallel testing
    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            initializeDriver();
        }
        return driverThreadLocal.get();
    }
    //    Creating and instantiating the WebDriver instance
    private static void initializeDriver() {
        switch (ConfigReader.getProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driverThreadLocal.set(ThreadGuard.protect(new ChromeDriver()));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driverThreadLocal.set(new FirefoxDriver());
                break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                driverThreadLocal.set(ThreadGuard.protect(new ChromeDriver(new ChromeOptions().setHeadless(true))));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driverThreadLocal.set(ThreadGuard.protect(new EdgeDriver()));
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driverThreadLocal.set(ThreadGuard.protect(new SafariDriver()));
                break;
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getDriver().manage().window().maximize();
    }
    //    if driver is pointing any object such as chrome or edge, then quit
    public static void closeDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}












