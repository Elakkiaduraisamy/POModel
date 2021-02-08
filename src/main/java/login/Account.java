package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import poLogin.POAccount;
import poLogin.POLogin;
import utilities.TestBase;

public class Account extends TestBase {
    POLogin pologin;
    POAccount poAccount;

    @BeforeTest
    public void settingDependency() throws Exception {
        poAccount = new POAccount(driverWeb);
        pologin = new POLogin(driverWeb);
        oSelUtil.goToSFDCUrl();
        pologin.loginSFDCPortal();
    }

    @Test
    public void launchSfdcAccountTab() throws Exception {
        poAccount.launchAccountTab();
    }
    @Test
    public void sfdcCreateAnAccount() throws Exception {
        poAccount.createAnAccount();
    }
    @Test
    public void sfdcCreateNewviewAccount() throws Exception {
        poAccount.createNewviewAccount();
    }

}
