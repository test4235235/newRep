package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utils;

public class AutomationTestMail {

    // "Zaloguj się" buttom
    @FindBy(xpath="//nav/div/a[2]")
    private WebElement btnSignIn;

    @FindBy(xpath="//*[@id=\'identifierId\']")
    private WebElement userlogin;

    private static Logger log;

    public AutomationTestMail(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Utils utils = new Utils();
        log = utils.initLogger();
    }

    public WebElement getuserlogin() {
        return userlogin;
    }

    public WebElement getBtnSignIn() {
        return btnSignIn;
    }
}
