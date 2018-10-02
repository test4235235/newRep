package utilities;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverUtils;

public class InitWebDriver {
  public WebDriver driver;
  public WebDriverUtils wbUtils;

  public void initWebDriver(){
    wbUtils = new WebDriverUtils();
    driver = wbUtils.initWebDriver("Google Chrome");
  }
}
