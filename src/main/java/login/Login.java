package login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import poLogin.POLogin;
import utilities.TestBase;

public class Login extends TestBase {

    POLogin poLogin;

    @BeforeMethod
    public void settingDependency(){
        poLogin = new POLogin(driverWeb);
        oSelUtil.goToSFDCUrl();

    }

    @Test
    public  void loginToSFDCWebAutomationPortal() throws Exception{
        extentTest = extentReports.createTest("Login To SFDCWebAutomation Portal");
        poLogin.loginSFDCPortal();
    }

    @Test
    public void loginToSFDCInvalidUser() throws Exception{
        extentTest = extentReports.createTest("LoginToSFDCInvalidUser");
        poLogin.loginSFDCPortalWithInvalidUser();
    }
    @Test
    public void loginToSfdcWithRememberBtn () throws Exception {
        extentTest = extentReports.createTest("LoginToSfdcWithRememberBtn");
        poLogin.LoginWithRememberBtn();

    }
    @Test
    public void LoginSfdcWithForgotPassword () throws Exception {
        extentTest = extentReports.createTest("LoginSfdcWithForgotPassword");
        poLogin.LoginWithForgotPassword();
    }


}
