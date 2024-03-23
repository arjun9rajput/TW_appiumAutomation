package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SkipBackupPage extends BasePage {


    public SkipBackupPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.Button")
    private  WebElement getStarterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Create new wallet\"]")
    //xpath used as accessibility is not provided
    private WebElement createWalletButton;

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Back up secret phrase\"]")
    private WebElement backUptext;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SKIP\"]")
    private WebElement skipButton;

    public void tapOnGetStartedButton(){
        clickOnElement(getStarterButton);
    }

    public void tapOnCreateWalletButton(){
        clickOnElement(createWalletButton);
    }

    public String getBackUpText(){
        return backUptext.getText();
    }

    public void tapOnSkipButton(){
        clickOnElement(skipButton);
    }
}
