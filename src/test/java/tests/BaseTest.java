package tests;

import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.DriverUtils.*;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        createAndroidDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        quitSession();
    }

}
