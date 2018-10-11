package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
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
    //@FindBy(css = "#\\3a 4s > div > div")
    @FindBy(xpath="//div[text()=\"Utwórz\"]")
    private WebElement Utworzbutton;

    // User typein "Do:" jaroslawzaloga@wp.pl
    @FindBy(name="to")
    private WebElement receiveraddress;

    // User typein "Temat:" First automation test code mail"
    @FindBy(name="subjectbox")
    private WebElement subjectofmessage;

    // User hit <Attach photo> button
    @FindBy(css="div[data-tooltip=\"Wstaw zdjęcie\"]")
    private WebElement addphoto;

    // User hit <Adres intertowy (URL)> button
    //@FindBy(css="div:contains(\"Adres internetowy (URL)\")")
    @FindBy(xpath="//div[text()=\"Adres internetowy (URL)\"]" )
    private WebElement TabAdresInternetowy;

    @FindBy(xpath="//*[@id=\":p\"]")
    private WebElement imagePath;

    @FindBy(id="picker:ap:2")
    private WebElement btnWstaw;

    // User typein "This is to confirm that first test code is ready and email is sent by application."
    @FindBy(css="div[aria-label=\"Treść wiadomości\"]")
    private WebElement messagebody;


    @FindBy(xpath="//*[@id=\":bc\"]")
    private WebElement btnattachment;

    // User hit "Wyślij"
    //@FindBy(xpath="//*[@id=\":9c\"]")
    @FindBy(css = "div[data-tooltip=\"Wyślij \u202A(Ctrl+Enter)\u202C\"]")
    private WebElement btnwyslij;

    // User hit "J" icon
 //   @FindBy(xpath="//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]/div/a/span")
    @FindBy(css="a[aria-label^=\"Konto Google:\"][aria-label$=\"gmail.com)\"]")
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

    public boolean clickbtnattachment() {
        return wdUtils.clickButon(btnattachment);
    }

    public boolean addphotoicon() {
        return wdUtils.clickButon(addphoto);
    }

    public boolean TabAdresInternetowy() {
        log.info("Link text - " + TabAdresInternetowy.getText());
        return wdUtils.clickButon(TabAdresInternetowy);
    }

    public boolean clickImagePath(){
        return wdUtils.clickButon(imagePath);
    }

    public boolean clickButtonWstaw(){
        return wdUtils.clickButon(btnWstaw);
    }

    public boolean setImagePath(String path) throws InterruptedException {
        boolean retValue = wdUtils.setTextForField(imagePath, path);
        Thread.sleep(2000);
        imagePath.sendKeys(Keys.SPACE);
        return retValue;
    }

    public boolean setMessageBody(String messageBody){
        wdUtils.setTextForField(messagebody, Keys.ENTER.toString());
        wdUtils.setTextForField(messagebody, Keys.ENTER.toString());
        wdUtils.setTextForField(messagebody, Keys.ENTER.toString());
        wdUtils.setTextForField(messagebody, Keys.TAB.toString());
        return wdUtils.setTextForField(messagebody, messageBody);
    }

    public boolean clickmessagebody(){
        return wdUtils.clickButon(messagebody);
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