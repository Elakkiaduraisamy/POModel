package poLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.SelUtility;
import utilities.TestBase;

import java.io.IOException;

public class POLogin extends TestBase {

    WebDriver driver;
    public POLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="username")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="Login")
    WebElement loginButton;

    @FindBy(xpath="//*[@id=\"userNav\"]")
    WebElement userNavBtn;

    @FindBy(xpath="//*[@id=\"error\"]")
    WebElement errorMessage;

    @FindBy(id = "rememberUn")
    WebElement rememberCheckBox;

    @FindBy(id = "userNavButton")
    WebElement accDropDown;

    @FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[5]")
    WebElement logout;

    @FindBy(xpath = "//*[@id=\"forgot_password_link\"]")
    WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"header\"]")
    WebElement forgottitlePage;

    @FindBy(xpath = "//*[@id=\"un\"]")
    WebElement usernameForgot;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"forgotPassForm\"]/div/p[1]")
    WebElement errorMessageTxt;


    public void loginSFDCPortal() throws Exception {
        oSelUtil.waitExplicitly(5, userName, driver);
        oSelUtil.webElementClear(userName);
        oSelUtil.webElementSendKeys(userName, properties.getProperty("sfdc.username"));
        oSelUtil.webElementClear(password);
        oSelUtil.webElementSendKeys(password, properties.getProperty("sfdc.password"));
        oSelUtil.webElementClick(rememberCheckBox);
        oSelUtil.webElementClick(loginButton);
        oSelUtil.waitExplicitly(5, userNavBtn, driver);

        String expectedTitle = properties.getProperty("sfdc.usernameTitle");
        String actualTitle = userNavBtn.getAttribute("title");
        oSelUtil.verifyText(actualTitle,expectedTitle,"HomePage");

    }


    public void loginSFDCPortalWithInvalidUser() throws Exception {
        oSelUtil.waitExplicitly(5, userName, driver);
        oSelUtil.webElementClear(userName);
        oSelUtil.webElementSendKeys(userName, properties.getProperty("sfdc.invalid.username"));
        oSelUtil.webElementClear(password);
        oSelUtil.webElementSendKeys(password, properties.getProperty("sfdc.password"));

        oSelUtil.webElementClick(loginButton);

        String expectedMsg = properties.getProperty("invalidUserName.errorMessage");
        String actualMsg = errorMessage.getText();

        oSelUtil.verifyText(actualMsg,expectedMsg,"Error Message");

    }

    public void LoginWithRememberBtn() throws Exception {
        oSelUtil.waitExplicitly(5, userName, driver);
        oSelUtil.webElementClear(userName);
        oSelUtil.webElementSendKeys(userName, properties.getProperty("sfdc.invalid.username"));
        oSelUtil.webElementClear(password);
        oSelUtil.webElementSendKeys(password, properties.getProperty("sfdc.password"));
        oSelUtil.webElementClick(rememberCheckBox);
        oSelUtil.webElementClick(loginButton);
        String expectedTitle = properties.getProperty("sfdc.usernameTitle");
        String actualTitle = userNavBtn.getAttribute("title");
        oSelUtil.verifyText(actualTitle, expectedTitle, "HomePage");
        oSelUtil.webElementClick(accDropDown);
        oSelUtil.webElementClick(logout);
        String actualNameDisplayed = userName.getText();
        String expectedNameDisplay = properties.getProperty("sfdc.username");
        Assert.assertEquals(expectedNameDisplay, actualNameDisplayed);
        oSelUtil.verifyText(expectedNameDisplay, actualNameDisplayed, "Remember Button Clicked");
    }
    public void LoginWithForgotPassword() throws Exception {
        oSelUtil.webElementClick(forgotPassword);
        String expectedTitlePage = properties.getProperty("sfdc.forgotTitlepage");
        String actualTitlePage = forgottitlePage.getText();
        oSelUtil.verifyText(actualTitlePage,expectedTitlePage,"Title of the page ");
        oSelUtil.webElementSendKeys(usernameForgot,properties.getProperty("sfdc.username"));
        oSelUtil.webElementClick(continueButton);
        String expectedMgs = properties.getProperty("forgotPassword.errorMessage");
        String actualMessage = errorMessageTxt.getText();
        Assert.assertEquals(expectedMgs,actualMessage);
        oSelUtil.verifyText(expectedMgs, actualMessage, "Error message");
//        closeBrowser(driver);
//        driver = launchBrowser(true)
    }

}