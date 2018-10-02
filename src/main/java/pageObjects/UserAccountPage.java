package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Utils;


public class UserAccountPage {
  //verify if user is logged in
  @FindBy(xpath="//div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a/span")
  private WebElement userNameNSurname;
  //order history and details
  @FindBy(xpath="//div[1]/div[2]/div/div[3]/div/div/div[1]/ul/li[1]/a")
  private WebElement linkOrderAndHistory;
  //orderHistoryMessage
  @FindBy(xpath="//div[1]/div[2]/div/div[3]/div/p")
  private WebElement txtUserHistoryMessage;
  //back to your account
  @FindBy(xpath="//div[1]/div[2]/div/div[3]/div/ul/li[1]/a")
  private WebElement btnBackToAccount;
  //log out
  @FindBy(xpath="//div[1]/div[1]/header/div[2]/div/div/nav/div[2]/a")
  private WebElement btnLogOut;

  private static Logger log;

  public UserAccountPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    Utils utils = new Utils();
    log = utils.initLogger();
  }

  public String getUserNameNSurname() throws NoSuchElementException {
    Assert.assertNotNull(userNameNSurname);
    return userNameNSurname.getText();
  }

  public void clickLinkOrderAndHistory() throws NoSuchElementException {
    Assert.assertNotNull(linkOrderAndHistory);
    linkOrderAndHistory.click();
  }

  public String getTxtUserHistoryMessage() throws NoSuchElementException {
    Assert.assertNotNull(txtUserHistoryMessage);
    return txtUserHistoryMessage.getText();
  }

  public void clickBtnBackToAccount() throws NoSuchElementException {
    Assert.assertNotNull(btnBackToAccount);
    btnBackToAccount.click();
  }

  public void clickBtnLogOut() throws NoSuchElementException {
    Assert.assertNotNull(btnLogOut);
    btnLogOut.click();
  }
}
