package stepDefinitions;

import utilities.InitWebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pageObjects.RegisterNewUserPage;
import utilities.Utils;

public class createUserAutomationPracticeStepDefinition extends InitWebDriver {
  private String url;
  public static Logger log;
  private RegisterNewUserPage registerNewUserPage;
  private String fullname;

  public createUserAutomationPracticeStepDefinition(){
    url = "http://automationpractice.com/index.php";
    initWebDriver();
    Utils utils = new Utils();
    log = utils.initLogger();
    registerNewUserPage = new RegisterNewUserPage(driver);
    fullname = "";
  }

  @Given("^user view Automation Practice web page$")
  public void userViewAutomationPracticeWebPage() {
    log.info("try to open automation practice web page - " + this.url);
    wbUtils.openWebPageURL(driver, this.url);
  }

  @When("^user click button register new user$")
  public void userClickButtonRegisterNewUser() {
    registerNewUserPage.clickBtnSignIn();
  }

  @Then("^user put adres mail \"([^\"]*)\"$")
  public void userPutAdresMail(String mail) {
    if(mail.equals(""))
      mail = "test" + System.currentTimeMillis() + "@wp.pl";
    registerNewUserPage.setTxtNewEmail(mail);
  }

  @Then("^user click button 'create new account'$")
  public void userClickButtonCreateNewAccount() {
    registerNewUserPage.clickBtnCreateAccount();
  }

  @Then("^user select title \"(.*)\"$")
  public void userSelectTitle(String title) {
    if(title.equals("Mrs")) registerNewUserPage.clickCheckTitleMrs();
    else if(title.equals("Mr")) registerNewUserPage.clickCheckTitleMr();
  }

  @Then("^user set firstname \"(.*)\"$")
  public void userSetFirstname(String firstName) {
    registerNewUserPage.setTxtFirstName(firstName);
    fullname = firstName + " ";
  }

  @Then("^user set lastname \"(.*)\"$")
  public void userSetLastname(String lastName) {
    registerNewUserPage.setTxtLastName(lastName);
    fullname = fullname + lastName;
  }

  @Then("^user set new address mail \"(.*)\"$")
  public void userSetNewAddressMail(String mail) {
    if(mail.equals(""))
      mail = "test" + System.currentTimeMillis() + "@wp.pl";
    registerNewUserPage.setTxtEmail(mail);
  }

  @Then("^user set password \"(.*)\"$")
  public void userSetPassword(String password) {
    registerNewUserPage.setTxtPassword(password);
  }

  @Then("^user set date of birth \"(.*)\"$")
  public void userSetDateOfBirth(String dteBirth) {
    String[] bDate = dteBirth.split("-");

    //day of birth
    registerNewUserPage.setTxtDayOfBirth(bDate[0]);
    //month of birth
    registerNewUserPage.setTxtMonthOfBirth(bDate[1]);
    //year of birth
    registerNewUserPage.setTxtYearOfBirth(bDate[2]);
  }

  @Then("^user click check 'newsletter'$")
  public void userClickCheckNewsletter() {
    registerNewUserPage.clickCheckNewsletter();
  }

  @Then("^user click check 'special offer'$")
  public void userClickCheckSpecialOffer() {
    registerNewUserPage.clickCheckSpecialOffer();
  }

  @Then("^user set text address firstname \"(.*)\"$")
  public void userSetTextAddressFirstname(String addressFirstname) {
    registerNewUserPage.setTxtAddressFirstName(addressFirstname);
  }

  @Then("^user set text address lastname \"(.*)\"$")
  public void userSetTextAddressLastname(String addressLastname) {
    registerNewUserPage.setTxtAddressLastName(addressLastname);
  }

  @Then("^user set text company \"(.*)\"$")
  public void userSetTextCompany(String company) {
    registerNewUserPage.setTxtCompany(company);
  }

  @Then("^user set text address \"(.*)\"$")
  public void userSetTextAddress(String address) {
    registerNewUserPage.setTxtAddress(address);
  }

  @Then("^User set text address line 2 \"(.*)\"$")
  public void userSetTextAddressLine(String addressLine2) {
    registerNewUserPage.setTxtAddressLine2(addressLine2);
  }

  @Then("^user set country name \"(.*)\"$")
  public void userSetCountryName(String country) {
    registerNewUserPage.setTxtCountry(country);
  }

  @Then("^user set city and state \"(.*)\"$")
  public void userSetCityAndState(String city_n_state) {
    registerNewUserPage.setTxtCity(city_n_state);
    registerNewUserPage.setTxtState(city_n_state);
  }

  @Then("^user set zipcode \"(.*)\"$")
  public void userSetzipcode(String zipcode) {
    registerNewUserPage.setTxtZipCode(zipcode);
  }

  @Then("^user set addition information text field \"(.*)\"$")
  public void userSetAdditionInformationTextField(String additional_information) {
    registerNewUserPage.setTxtAdditionalInformation(additional_information);
  }

  @Then("^user set home phone \"(.*)\" and mobile phone \"(.*)\"$")
  public void userSetHomePhoneAndMobilePhone(String homePhone, String mobilePhone) {
    registerNewUserPage.setTxtHomePhone(homePhone);
    registerNewUserPage.setTxtMobilePhone(mobilePhone);
  }

  @Then("^user set address alias \"(.*)\"$")
  public void userSetAddressAlias(String address_alias) {
    registerNewUserPage.setTxtAddressAlias(address_alias);
  }

  @Then("^user click 'register new user'$")
  public void userClickRegisterNewUser() {
    registerNewUserPage.clickBtnRegister();
  }

  @Then("^user verify is logged in$")
  public void userVerifyIsLoggedIn() {
    String uname = registerNewUserPage.getUserNameNSurname();
    Assert.assertEquals(uname, fullname);
  }

  @AfterClass
  public void close_browser(){
    log.info("try to close driver and web page");
    driver.close();
  }
}
