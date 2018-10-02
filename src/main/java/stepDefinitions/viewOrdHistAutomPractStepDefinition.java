package stepDefinitions;

import utilities.InitWebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pageObjects.UserAccountPage;
import utilities.Utils;

public class viewOrdHistAutomPractStepDefinition extends InitWebDriver {
  public static Logger log;
  private UserAccountPage userAccountPage;

  public viewOrdHistAutomPractStepDefinition(){
    initWebDriver();
    Utils utils = new Utils();
    log = utils.initLogger();
    userAccountPage = new UserAccountPage(driver);
  }

  @Given("^user is logged in to account$")
  public void user_logged_in_account() throws Exception{
    String uname = userAccountPage.getUserNameNSurname();
    Assert.assertEquals(uname, "Antoni Giez");
  }

  @When("^user click link to history order$")
  public void user_click_link_order_history() throws Exception{
    userAccountPage.clickLinkOrderAndHistory();
  }

  @Then("^user see page history order$")
  public void user_view_order_history_page() throws Exception{
    String orderHistoryMessage = userAccountPage.getTxtUserHistoryMessage();
    Assert.assertEquals(orderHistoryMessage, "Here are the orders you've placed since your account was created.");
  }

  @Then("^user come back to main account page and log out$")
  public void come_back_main_account_and_log_out() throws Exception{
    //back to your account
    userAccountPage.clickBtnBackToAccount();
    userAccountPage.clickBtnLogOut();
  }

  @AfterClass
  public void close_the_browser(){
    log.info("try to close driver and web page");
    driver.close();
  }
}
