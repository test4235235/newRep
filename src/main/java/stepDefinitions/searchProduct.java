package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pageObjects.userMenu;
import utilities.InitWebDriver;
import utilities.Utils;

public class searchProduct extends InitWebDriver {
  public static Logger log;
  userMenu uMenu;

  public searchProduct(){
    initWebDriver();
    Utils utils = new Utils();
    log = utils.initLogger();
    uMenu = new userMenu(driver);
  }

  @Given("^web page of automation practice \"(.*)\"$")
  public void webpageOfAutomationPractice(String url) {
    log.info("try to open automation practice web page - " + url);
    wbUtils.openWebPageURL(driver, url);
  }

  @When("^user move mouse cursor to top level menu category \"(.*)\"$")
  public void userMoveMouseCursorToTopLevelMenuCategory(String optMenu) {
    Assert.assertTrue(uMenu.moveMousePointerOnMenuOption(optMenu), "Unable to find menu option");
  }

  @Then("^submenu will appear and user select subcategory \"(.*)\"$")
  public void submenuWillAppearAndUserSelectSubcategory(String optSubMenu) throws InterruptedException {
    Thread.sleep(2000);
    Assert.assertTrue(uMenu.selectSubMenuOption(optSubMenu), "Unable to find submenu option");
  }

  @Then("^user select value of sort order \"(.*)\"$")
  public void userSelectValueOfSortOrder(String selectOption) {
    Assert.assertTrue(uMenu.selectSortOrderByValue(selectOption), "Unable to select sort order");
  }

  @AfterClass
  public void close_browser(){
    log.info("try to close driver and web page");
    driver.close();
  }
}
