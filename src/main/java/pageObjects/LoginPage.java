package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;



public class LoginPage {
  //sign in
  @FindBy(xpath="//div/div[1]/header/div[2]/div/div/nav/div[1]/a")
  private WebElement btnSignIn;
  //email
  @FindBy(xpath="//*[@id=\'email\']")
  private WebElement txtLoginEmail;
  //password
  @FindBy(xpath="//*[@id=\'password\']")
  private WebElement txtLoginPassword;
  //button login
  @FindBy(xpath="//*[@id=\'SubmitLogin\']")
  private WebElement btnLogIn;
  //link sign out
  @FindBy(xpath="//div/div[1]/header/div[2]/div/div/nav/div[2]/a")
  private WebElement linkSignOut;
  //link user name and surname
  @FindBy(xpath="//div/div[1]/header/div[2]/div/div/nav/div[1]/a")
  private WebElement linkUserFullname;

  private static Logger log;

  public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    Utils utils = new Utils();
    log = utils.initLogger();
  }

  public void clickBtnSignIn() throws NoSuchElementException {
    Assert.assertNotNull(btnSignIn);
    btnSignIn.click();
  }

  public void setTxtLoginEmail(String loginEmail) throws NoSuchElementException {
    Assert.assertNotNull(txtLoginEmail);
    txtLoginEmail.sendKeys(loginEmail);
  }

  public void setTxtLoginPassword(String loginPassword) throws NoSuchElementException {
    Assert.assertNotNull(txtLoginPassword);
    txtLoginPassword.sendKeys(loginPassword);
  }

  public void clickBtnLogIn() throws NoSuchElementException {
    Assert.assertNotNull(btnLogIn);
    btnLogIn.click();
  }
  public WebElement getLinkSignOut(){
    return linkSignOut;
  }
  public WebElement getLinkUserFullname(){
    return linkUserFullname;
  }
}
