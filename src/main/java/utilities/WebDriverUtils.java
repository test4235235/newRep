package utilities;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
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
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                log.info("start run Mozilla Firefox browser");
                isDriverInitialized = true;
            }
            if(nameWebBrowser.equals("Google Chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                log.info("start run Google Chrome browser");
                isDriverInitialized = true;
            }
            if(nameWebBrowser.equals("Internet Explorer")){
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                log.info("start run Internet Explorer browser");
                isDriverInitialized = true;
            }
            if(nameWebBrowser.equals("Microsoft Edge")){
                WebDriverManager.edgedriver().setup();
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

    public boolean setTextForField(WebElement element, String text){
        try {
            element.sendKeys(text);
            return true;
        }
        catch (Exception e) {
            log.info("exception",e);
            throw e;
        }
    }

    public boolean clickButon(WebElement element){
        try {
            element.click();
            return true;
        }
        catch (Exception e) {
            log.info("exception",e);
            throw e;
        }
    }
}
