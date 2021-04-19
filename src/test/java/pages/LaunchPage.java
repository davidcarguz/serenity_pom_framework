package pages;

import core.ReportManager;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LaunchPage extends PageObject {


    @FindBy(how = How.CSS,using = "input[id = 'user-name']")
    WebElement edt_username;
    @FindBy(how = How.CSS,using = "input[id = 'password']")
    WebElement edt_password;
    @FindBy(how = How.CSS,using = "input[id = 'login-button']")
    WebElement btn_login;


    public LaunchPage(){
        PageFactory.initElements(getDriver(),this);
    }

    public void navigateToLaunchPage(){
        getDriver().get("https://www.saucedemo.com/");
        Assert.assertTrue(btn_login.isDisplayed());
        ReportManager.test.info("navigate to landing page")
                .addScreenCaptureFromPath(ReportManager.takeStepScreenshot(getDriver(),"landing page",ReportManager.scenarioName));
    }

    public LaunchPage enterUsername(String username) {
        edt_username.sendKeys(username);
        ReportManager.test.info("enter username,")
                .addScreenCaptureFromPath(ReportManager.takeStepScreenshot(getDriver(),"enter username",ReportManager.scenarioName));
        return this;
    }

    public LaunchPage enterPassword(String password) {
        edt_password.sendKeys(password);
        ReportManager.test.info("enter password")
                .addScreenCaptureFromPath(ReportManager.takeStepScreenshot(getDriver(),"enter password",ReportManager.scenarioName));
        return this;
    }

    public void clickLoginButton() {
        btn_login.click();
    }
}
