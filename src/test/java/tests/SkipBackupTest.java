package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SkipBackupPage;

import static utils.DriverUtils.getDriver;

public class SkipBackupTest extends BaseTest {

    @Test(description = "Verify user is able to create wallet when backup is skipped")
    public void skipBackupTest() {
        SkipBackupPage skipBackupPage =new SkipBackupPage(getDriver());
        skipBackupPage.tapOnGetStartedButton();
        skipBackupPage.tapOnCreateWalletButton();
        Assert.assertEquals(skipBackupPage.getBackUpText(),"Back up secret phrase");
        skipBackupPage.tapOnSkipButton();
    }
}
