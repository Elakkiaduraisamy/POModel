package com.sfdc.pomodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.sfdc.utilities.TestBase.oSelUtil;
import static com.sfdc.utilities.TestBase.properties;

public class POContact {

    WebDriver driver;
    public POContact(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//*[@id=\"Contact_Tab\"]/a")
    WebElement contactTab;

    @FindBy(xpath="//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h1")
    WebElement titleContact;


    public  void launchingContactTab() throws Exception {
        oSelUtil.waitExplicitly(8, contactTab, driver);
        oSelUtil.webElementClick(contactTab);
        oSelUtil.waitExplicitly(8, titleContact, driver);
        String expectedTitle = properties.getProperty("sfdc.ContactTitle");
        String actualTitle = titleContact.getText();
        oSelUtil.verifyText(expectedTitle,actualTitle,"Title page ");
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
