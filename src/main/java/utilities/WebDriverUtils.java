package utilities;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WebDriverUtils {
    private static Logger log;

    public WebDriverUtils(){
        Utils u = new Utils();
        log = u.initLogger();
    }

    public WebDriver initWebDriver(String nameWebBrowser){
        WebDriver driver = null;
        boolean isDriverInitialized = false;
        try{
            if(nameWebBrowser.equals("Mozilla Firefox")){
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver-v0.20.1-win64/geckodriver.exe");
                driver = new FirefoxDriver();
                log.info("start run Mozilla Firefox browser");
                isDriverInitialized = true;
            }
            if(nameWebBrowser.equals("Google Chrome")){
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver_win32/chromedriver.exe");
                driver = new ChromeDriver();
                log.info("start run Google Chrome browser");
                isDriverInitialized = true;
            }
            if(nameWebBrowser.equals("Internet Explorer")){
                System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer_x64_3.9.0/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                log.info("start run Internet Explorer browser");
                isDriverInitialized = true;
            }
            if(nameWebBrowser.equals("Microsoft Edge")){
                System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                log.info("start run Microsoft Edge browser");
                isDriverInitialized = true;
            }
            if(!isDriverInitialized){
                log.info("User had selected not supported web browser");
            }
        }catch(Exception e){
            log.error("Web driver was not initialized successfully", e);
        }
        return driver;
    }

    public boolean openWebPageURL(WebDriver d, String url){
        try {
            d.get(url);
            d.manage().window().maximize();
            d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return true;
        }catch(Exception ex){
            log.info("Exception occured", ex);
            return false;
        }
    }
}
