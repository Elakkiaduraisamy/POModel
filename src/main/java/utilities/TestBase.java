package utilities;

import com.jayway.jsonpath.JsonPath;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class TestBase {
    public static String sBrowser;
    public static String sConfig;
    public static String sAutomation;
    WebDrManager driverManagerWeb = new WebDrManager();
    public WebDriver driverWeb;

    Logger log = Logger.getLogger(getClass().getSimpleName());
    public static SelUtility oSelUtil = new SelUtility();
    public static CommonUtilities oCommonUtil = new CommonUtilities();
    public static Properties properties;
    @BeforeSuite
    public void dependencyFulfillMent() throws Exception{
        oCommonUtil.loadLog4jProperty(System.getProperty("user.dir") + "/resources/testdata/Log4js2.properties");
        sConfig = CommonUtilities.readfileReturnInString(System.getProperty("user.dir") + "/resources/testdata/config.json");
        sAutomation = JsonPath.read(sConfig, "automation");
        properties = oSelUtil.getProperties();
        if(sAutomation.toLowerCase().equals("web")){
            sBrowser = JsonPath.read(sConfig, "browser");
            driverWeb = oSelUtil.launchApp();
            log.info("driverWeb :- " + driverWeb);
        }

    }


    @AfterSuite
    public void terminateApp() throws Exception{
        if(sAutomation.toLowerCase().equals("web")){
            oSelUtil.quitApp();
        }
    }


}
