//For the reviewer

The apk has secure flag set to TRUE. Automation of

1. Skip Backup
2. Manual Backup
3. Google Drive backup

can only be done when secure flag is set to False.

//I have modified the original framework a little bit.
1.I have created a separate AppiumServerManager class to have separation other utils.
2. Modified the DriverUtils to add separate functions to createAndroidDriver, quitDriver,getDriver and Desiredcapabalities method.
3. It would be better to create separate classes to launch AndroidDriver and iOSDriver and the appium arguments can be controlled via AppiumServerManager

//I have used AppiumFindBy as my locator strategy, as it provides a clean look to the class.
1. An improvement can be suggested to have accessibility ids and ids as part of attributes for the elements. Use of xpath as locator strategy is not recommended.