package poLogin;

import login.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class POAccount extends TestBase {
    WebDriver driver;
    public POAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="Account_Tab")
    WebElement accountTab;

    @FindBy(xpath = "//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1")
    WebElement titlePage;

    @FindBy(xpath="//input[@value=' New ']")
    WebElement newAccBtn;

    @FindBy(xpath="//*[@id=\"acc2\"]")
    WebElement newAccNameTxtBox;

    @FindBy(xpath="//*[@id=\"bottomButtonRow\"]/input[1]")
    WebElement saveBtn;

    @FindBy(xpath="//h2[@class='topName']")
    WebElement accNameTitle;

    @FindBy(xpath = "//*[@id=\"filter_element\"]/div/span/span[2]/a[2]" )
    WebElement createNewView;

    @FindBy(xpath = "//input[@id=\"fname\"]")
    WebElement viewName;

    @FindBy(xpath = "//*[@id=\"devname\"]")
    WebElement uniqueName;

    @FindBy(xpath = "//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]" )
    WebElement saveBtn2;

    @FindBy(xpath = "//*[@name='fcf']" )
    WebElement viewOptions;

    public void launchAccountTab() throws Exception {
        oSelUtil.waitExplicitly(5, accountTab, driver);
        oSelUtil.webElementClick(accountTab);
        oSelUtil.waitExplicitly(5,titlePage , driver);
        oSelUtil.verifyText(titlePage.getText(),properties.getProperty("sfdc.AccTitleName"), "Account Title page");

    }
    @Test
    public void createAnAccount() throws Exception {
        oSelUtil.webElementClick(newAccBtn);
        oSelUtil.webElementSendKeys(newAccNameTxtBox,properties.getProperty("sfdc.newAccName"));
        oSelUtil.webElementClick(saveBtn);
        String expectedTitle = properties.getProperty("sfdc.newAccName");
        String actualTitle = accNameTitle.getText();
        oSelUtil.verifyText(expectedTitle,actualTitle,"Account Name added ");
    }
    @Test
    public void createNewviewAccount() throws Exception{
        launchAccountTab();
        oSelUtil.waitExplicitly(5, createNewView, driver);
        oSelUtil.webElementClick(createNewView);
        oSelUtil.waitExplicitly(5, viewName, driver);
        oSelUtil.webElementSendKeys(viewName,properties.getProperty("sfdc.newViewName"));
        oSelUtil.webElementClick(uniqueName);
        oSelUtil.webElementClick(saveBtn2);
        oSelUtil.waitExplicitly(10, viewOptions, driver);
        Select s = new Select(viewOptions);
        List<WebElement> actualviewOptionsList = s.getOptions();
        Set<String> expectedViewOptionList = new HashSet<>();
        expectedViewOptionList.add("All Accounts");
        expectedViewOptionList.add("New Last Week");
        expectedViewOptionList.add("New This Week");
        expectedViewOptionList.add("Platinum and Gold SLA Customers");
        expectedViewOptionList.add("Recently Viewed Accounts");
        expectedViewOptionList.add("jaagu");
        Assert.assertEquals(expectedViewOptionList.size(),actualviewOptionsList.size());
        oSelUtil.verifyListOptions(expectedViewOptionList,actualviewOptionsList,"ListOfViewOptions");
    }
}

