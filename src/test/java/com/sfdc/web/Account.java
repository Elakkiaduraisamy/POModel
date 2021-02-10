package com.sfdc.web;

import com.sfdc.pomodel.POAccount;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.sfdc.pomodel.POLogin;
import com.sfdc.utilities.TestBase;

public class Account extends TestBase {
    POLogin pologin;
    POAccount poAccount;

    @BeforeClass
    public void settingDependency() throws Exception {
        poAccount = new POAccount(driverWeb);
        pologin = new POLogin(driverWeb);
        oSelUtil.goToSFDCUrl();
        pologin.loginSFDCPortal(9);
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
    public void sfdcCreateNewViewAccount() throws Exception {
        poAccount.createNewviewAccount();
    }

}
