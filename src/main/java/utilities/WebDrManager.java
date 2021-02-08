package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class WebDrManager implements IWebDriver, IDriverManager {

    WebDriver driver;
    
    @Override
    public void launchApp(String sBrowserType) {
        if(sBrowserType.toLowerCase().equals("chrome")){
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
    }

    @Override
    public void quitApp() {
        driver.quit();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
