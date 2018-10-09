package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utils;
import utilities.WebDriverUtils;

public class LoginFormGoogle {
    // User type in login:"lozagajarek@gmail.com"
    @FindBy(xpath="//*[@id=\"identifierId\"]")
    private WebElement btnSignIn;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]")
    private WebElement buttonLoginNext;

    // User typein password "Rudyna102"
    @FindBy(xpath="//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement textpassword;

    @FindBy(xpath="//*[@id=\"passwordNext\"]")
    private WebElement buttonPasswordNext;

    // User hit <Utwórz> button
    //@FindBy(xpath="//*[@id=\":78\"]/div/div")
    @FindBy(css = "#\\3a 4s > div > div")
    private WebElement Utworzbutton;

    // User typein "Do:" jaroslawzaloga@wp.pl
    @FindBy(xpath="//*[@id=\":a1\"]")
    private WebElement receiveraddress;

    // User typein "Temat:" First automation test code mail"
    @FindBy(xpath="//*[@id=\":aj\"]")
    private WebElement subjectofmessage;

    // User typein "This is to confirm that first test code is ready and email is sent by application."
    @FindBy(xpath="//*[@id=\":aj\"]")
    private WebElement messagebody;

    // User hit "Wyślij"
    @FindBy(xpath="//*[@id=\":kk\"]")
    private WebElement btnwyslij;

    // User hit "J" icon
    @FindBy(xpath="//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]/div/a/span")
    private WebElement userprofile;

    // User hit <Wyloguj> button
    @FindBy(xpath="//*[@id=\"gb_71\"]")
    private WebElement logout;



    private static Logger log;
    WebDriverUtils wdUtils;

    public LoginFormGoogle(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Utils utils = new Utils();
        wdUtils = new WebDriverUtils();
        log = utils.initLogger();
    }

    public boolean setusername(String UserName){
        return wdUtils.setTextForField(btnSignIn, UserName);
    }

    public boolean clickButtonLoginNext(){
        return wdUtils.clickButon(buttonLoginNext);
    }

    public boolean setuserpassword(String UserPassword){
        return wdUtils.setTextForField(textpassword, UserPassword);
    }

    public boolean clickButtonPasswordNext(){
        return wdUtils.clickButon(buttonPasswordNext);
    }

    public boolean clickUtworzBtn(){
        return wdUtils.clickButon(Utworzbutton);
    }

    public boolean receiveraddress(String mailReceiver){
        return wdUtils.setTextForField(receiveraddress, mailReceiver);
    }

    public boolean setSubjectofmessage(String mailTitle){
        return wdUtils.setTextForField(subjectofmessage, mailTitle);
    }
    public boolean setMessageBody(String messageBody){
        return wdUtils.setTextForField(messagebody, messageBody);
    }
    public boolean clickbuttonwyslij(){
        return wdUtils.clickButon(btnwyslij);
    }

    public boolean clickbuttonuserprofile(){
        return wdUtils.clickButon(userprofile);
    }

    public boolean clicklogout(){
        return wdUtils.clickButon(logout);
    }

}

//*[@id="gb_71"]