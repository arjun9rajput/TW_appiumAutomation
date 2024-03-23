package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.*;

public class AppiumServerManager {
    public static AppiumDriverLocalService service;
    public static void startServer () {
        final AppiumServiceBuilder builder = new AppiumServiceBuilder ();
        builder.withIPAddress ("127.0.0.1")
                    .usingPort (4723)
                    .withArgument (BASEPATH, "/wd/hub")
                    .withArgument (SESSION_OVERRIDE)
                    .withArgument (USE_DRIVERS, "uiautomator2");


        service = AppiumDriverLocalService.buildService (builder);
        service.start ();
    }

    public static void stopServer () {
        service.stop ();
    }
}
