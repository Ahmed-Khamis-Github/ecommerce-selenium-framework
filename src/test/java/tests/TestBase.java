package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        String downloadFilePath = new File("Downloads").getAbsolutePath();

        if(browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default_directory", downloadFilePath);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS) ;
        driver.get("https://demo.nopcommerce.com/");

    }

    @AfterSuite
    public void stopDriver() {
        driver.quit();
    }

    @AfterMethod
    public void screenShotOnFailure(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test failed: " + result.getName());
            System.out.println("Taking screenshot...");
            try {
                 Helper.CaptureScreenshot(driver, result.getName());
            } catch (Exception e) {
                System.out.println("An error occurred while taking the screenshot: " + e.getMessage());
            }
        }
    }

}
