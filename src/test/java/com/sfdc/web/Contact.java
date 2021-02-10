package com.sfdc.web;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.sfdc.pomodel.POContact;
import com.sfdc.pomodel.POLogin;
import com.sfdc.utilities.TestBase;

public class Contact extends TestBase {
    POLogin pologin;
    POContact poContact;

    @BeforeClass
    public void settingDependency() throws Exception {
        poContact = new POContact(driverWeb);
        pologin = new POLogin(driverWeb);
        oSelUtil.goToSFDCUrl();
        pologin.loginSFDCPortal(9);
    }
    @Test(priority=4)
    public void sfdcLaunchContact() throws Exception {
        poContact.launchingContactTab();
    }

}
