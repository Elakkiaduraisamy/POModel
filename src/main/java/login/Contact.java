package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import poLogin.POAccount;
import poLogin.POContact;
import poLogin.POLogin;
import utilities.TestBase;

public class Contact extends TestBase {
    POLogin pologin;
    POContact poContact;

    @BeforeMethod
    public void settingDependency() throws Exception {
        poContact = new POContact(driverWeb);
        pologin = new POLogin(driverWeb);
        oSelUtil.goToSFDCUrl();
        pologin.loginSFDCPortal();
    }
    @Test
    public void sfdcLaunchContact() throws Exception {
        poContact.launchingContactTab();
    }

}
