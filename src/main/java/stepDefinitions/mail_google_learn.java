package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import pageObjects.AutomationTestMail;
import pageObjects.LoginFormGoogle;
import utilities.InitWebDriver;
import utilities.Utils;

import java.util.Set;

public class mail_google_learn extends InitWebDriver {
    public static Logger log;
    AutomationTestMail gmailpage;
    LoginFormGoogle loginform;

    public mail_google_learn(){
        initWebDriver();
        Utils utils = new Utils();
        log = utils.initLogger();
        gmailpage = new AutomationTestMail(driver);
        loginform = new LoginFormGoogle(driver);
    }

    @Given("^type webpage url for gmail home page \"([^\"]*)\"$")
    public void typeWebpageUrlForGmailHomePage(String url) {
        log.info("Try to open web page " + url);
        wbUtils.openWebPageURL(driver, url);
    }

    @Then("^hit <Zaloguj się>$")
    public void hitZalogujSię() {
        gmailpage.getBtnSignIn().click();
    }

    @Then("^typein user login \"([^\"]*)\"$")
    public void typeinUserLogin(String username) {
        loginform.setusername(username);
    }

    @Then("^click <Dalejlogin>$")
    public void clickDalejlogin() {
        loginform.clickButtonLoginNext();
    }

    @Then("^typein user password \"([^\"]*)\"$")
    public void typeinUserPassword(String password) {
        loginform.setuserpassword(password);
    }
    @Then("^click <Dalejpassword>$")
    public void clickDalejpassword() throws InterruptedException {
        Thread.sleep(2000);
        loginform.clickButtonPasswordNext();
    }
    @Then("^click <Utwórz>$")
    public void clickNewMail() throws InterruptedException{
        Thread.sleep(10000);
        loginform.clickUtworzBtn();
        //driver.switchTo().activeElement();
        Set<String> windowHandlers = driver.getWindowHandles();
        for(String winHandler : windowHandlers){
            log.info("Window handler - " + winHandler);
            driver.switchTo().window(winHandler);
        }
    }

    @Then("^type receiver mail \"([^\"]*)\"$")
    public void typeReceiverMail(String MailReceiver) throws InterruptedException{
        Thread.sleep(5000);
        loginform.receiveraddress(MailReceiver);
    }

    @Then("^type \"([^\"]*)\" in message title$")
    public void typeInMessageTitle(String MailTitle) {
        loginform.setSubjectofmessage(MailTitle);
    }

    @Then("^type in message body text \"([^\"]*)\"$")
    public void typeInMessageBodyText(String mailMessage) {
        loginform.setMessageBody(mailMessage);
    }

    @Then("^hit 'Wyslij' button$")
    public void hitWyslijButton() {
        loginform.clickbuttonwyslij();
    }

    @Then("^hit 'J' profile icon$")
    public void hitJProfileIcon() {
        loginform.clickbuttonuserprofile();
    }

    @Then("^hit 'Wyloguj' button$")
    public void hitWylogujButton() {
        loginform.clicklogout();
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
