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

        poLogin.loginSFDCPortal();
    }

    @Test
    public void loginToSFDCInvalidUser() throws Exception{
        poLogin.loginSFDCPortalWithInvalidUser();
    }
    @Test
    public void loginToSfdcWithRememberBtn () throws Exception {
        poLogin.LoginWithRememberBtn();

    }
    @Test
    public void LoginSfdcWithForgotPassword () throws Exception {
        poLogin.LoginWithForgotPassword();

    }


}
