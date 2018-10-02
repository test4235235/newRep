package appModules;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pageObjects.UserAccountPage;
import utilities.Utils;

public class TestUserAccountModule {
  private static Logger log;
  private UserAccountPage userAccountPage;

  public TestUserAccountModule(WebDriver driver){
    Utils utils = new Utils();
    log = utils.initLogger();
    log.info("\n\nStart - test module login page");
    userAccountPage = new UserAccountPage(driver);
  }

  public boolean verifyUserName(String userNameSurname) throws Exception{
    try {
      //verify if user is logged in
      String uname = userAccountPage.getUserNameNSurname();
      Assert.assertEquals(uname, userNameSurname);
      return true;
    }catch(Exception e){
      log.info("Exception occured ", e);
      throw (e);
    }
  }

  public boolean checkUserHistory() throws Exception{
    try {
      //order history and details
      userAccountPage.clickLinkOrderAndHistory();
      String orderHistoryMessage = userAccountPage.getTxtUserHistoryMessage();
      Assert.assertEquals(orderHistoryMessage, "Here are the orders you've placed since your account was created.");
      //back to your account
      userAccountPage.clickBtnBackToAccount();
      //sign out
      //loginPage.clickBtnLogOut();
      return true;
    }catch(Exception e){
      log.info("Exception occured ", e);
      throw (e);
    }
  }

  public boolean logOutUser() throws Exception{
    try {
      //sign out
      userAccountPage.clickBtnLogOut();
      return true;
    }catch(Exception e){
      log.info("Exception occured ", e);
      throw (e);
    }
  }
}
