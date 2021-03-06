package stepDefinitions;

import pageObjects.UserAccountPage;
import utilities.InitWebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pageObjects.LoginPage;
import utilities.Utils;


public class automationPracticeStepDefinition extends InitWebDriver {
  private String url;
  LoginPage pageLogin;
  UserAccountPage userAccountPage;
  public static Logger log;

  public automationPracticeStepDefinition(){
    url = "http://automationpractice.com/index.php";
    initWebDriver();
    Utils utils = new Utils();
    log = utils.initLogger();
    pageLogin = new LoginPage(driver);
    userAccountPage = new UserAccountPage(driver);
  }

  @Given("^user is on automation practice web page$")
  public void open_automation_practice_webpage(){
    log.info("try to open automation practice web page - " + this.url);
    wbUtils.openWebPageURL(driver, this.url);
  }

  @When("^user click link text 'Sign In'$")
  public void click_link_sign_in(){
    log.info("try to click link sign in");
    pageLogin.clickBtnSignIn();
    //driver.findElement(By.xpath("//div/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
  }

  @Then("^user fill text fields with username \"(.*)\" and password \"(.*)\"$")
  public void fill_username_and_password(String username, String password){
    log.info("try to put username and password");
    pageLogin.setTxtLoginEmail(username);
    //driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(username);
    pageLogin.setTxtLoginPassword(password);
    //driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys(password);
  }

  @Then("^user click button sign in$")
  public void click_button_signin() throws Exception {
    log.info("try to click button sign in");
    pageLogin.clickBtnLogIn();
    //driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
    WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until(ExpectedConditions.elementToBeClickable(pageLogin.getLinkSignOut()));
  }

  @Then("^user check is logged in$")
  public void check_user_logged(){
    //check if is available option sign out
    log.info("try to check if user is logged in");
    String linkSignOut = pageLogin.getLinkSignOut().getText();
    Assert.assertTrue(linkSignOut.equals("Sign out"), "There is no visible link sign out");
    String linkUserName = pageLogin.getLinkUserFullname().getText();
    Assert.assertTrue(linkUserName.equals("Antoni Giez"));
    log.info("user is logged in, username - " + linkUserName);
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
