package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import pageObjects.AutomationTestMail;
import pageObjects.LoginFormGoogle;
import utilities.InitWebDriver;
import utilities.Utils;

import java.util.List;
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
    public void typeReceiverMail(String MailReceiver){
       loginform.receiveraddress(MailReceiver);
    }

    @Then("^type \"([^\"]*)\" in message title$")
    public void typeInMessageTitle(String MailTitle) throws InterruptedException {
        loginform.setSubjectofmessage(MailTitle);
        Thread.sleep(1000);
    }

    @Then("^click <add photo> \"([^\"]*)\"$")
    public void addPhoto(String FindPhoto) throws InterruptedException{
        loginform.addphotoicon();
        Thread.sleep(5000);
        List<WebElement> lstElements = driver.findElements(By.tagName("iframe"));
        for(WebElement el : lstElements){
            System.out.println("frame - " + el.getAttribute("id"));
        }
        String frameHandle = lstElements.get(lstElements.size()-1).getAttribute("id");
        System.out.println("id of last frame - " + frameHandle + "\n\n\n");
        driver.switchTo().frame(frameHandle);
        loginform.TabAdresInternetowy();

        loginform.clickImagePath();
        loginform.setImagePath(FindPhoto);

        Thread.sleep(5000);
        loginform.clickButtonWstaw();
    }

//--------------------------------------------
//    @Then("^click <Adres internetowy \\(URL\\)>$")
//    public void click_Adres_internetowy_URL() throws InterruptedException {
//        loginform.TabAdresInternetowy();
//    }
//---------------------------------------------


//    @Then("^click <Dodanie załącznika> \"([^\"]*)\"$")
//    public void clickDodanieZałącznika(String attachmentpath) throws InterruptedException {
//        loginform.setMessageBody(attachmentpath);
//        loginform.clickmessagebody();
//        Actions a= new Actions(driver);
//        a.sendKeys(Keys.chord(Keys.CONTROL,"a")).build().perform();
//        a.sendKeys(Keys.chord(Keys.CONTROL,"x")).build().perform();
//        loginform.clickbtnattachment();
//        WebDriverWait wait= new WebDriverWait(driver, 3000);
//        Thread.sleep(5000);
//        Alert b = driver.switchTo().alert();
//
//        a.sendKeys(Keys.chord(Keys.CONTROL,"v")).build().perform();
//       a.sendKeys(Keys.ENTER).build().perform();
//    }

    @Then("^type in message body text \"([^\"]*)\"$")
    public void typeInMessageBodyText(String mailMessage) throws InterruptedException {
        loginform.setMessageBody(mailMessage);
    }

    @Then("^hit 'Wyslij' button$")
    public void hitWyslijButton() {
        loginform.clickbuttonwyslij();
    }

    @Then("^hit 'J' profile icon$")
    public void hitJProfileIcon() throws InterruptedException {
        loginform.clickbuttonuserprofile();

        Thread.sleep(5000);
    }

    @Then("^hit 'Wyloguj' button$")
    public void hitWylogujButton() throws InterruptedException {
        loginform.clicklogout();
        Thread.sleep(4000);
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
