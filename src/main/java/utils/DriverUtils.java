package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;

import static utils.AppiumServerManager.startServer;
import static utils.AppiumServerManager.stopServer;

public class DriverUtils {
    private static final String
            APP_PATH = String.valueOf (
            Path.of (System.getProperty ("user.dir"), "/src/test/resources/app", "v8.7.1_release.apk"));
    private static final ThreadLocal<AndroidDriver> DRIVER   = new ThreadLocal<> ();


    public static void createAndroidDriver () {
        startServer ();
        try {
            setDriver (new AndroidDriver (new URL ("http://127.0.0.1:4723/wd/hub"),setCapabilities()));
        } catch (final MalformedURLException e) {
            throw new RuntimeException (e);
        }
        setupDriverTimeouts ();
    }

    public static AndroidDriver getDriver () {
        return DriverUtils.DRIVER.get ();
    }

        private static DesiredCapabilities setCapabilities() {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", APP_PATH);
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Pixel3A");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("noReset", false);

            return capabilities;
        }


    public static void quitSession () {
        if (null != DRIVER.get ()) {
            getDriver ().quit ();
            DRIVER.remove ();
            stopServer ();
        }
    }

    private static void setDriver (final AndroidDriver driver) {
        DriverUtils.DRIVER.set (driver);
    }

    private static void setupDriverTimeouts () {
        getDriver ().manage ()
                .timeouts ()
                .implicitlyWait (Duration.ofSeconds (5));
    }


}
