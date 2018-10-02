package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Utils;


public class RegisterNewUserPage {
  //sign in
  @FindBy(xpath="//div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a")
  private WebElement btnSignIn;
  //enter e-mail
  @FindBy(xpath="//*[@id=\'email_create\']")
  private WebElement txtNewEmail;
  //click "Create an account"
  @FindBy(xpath="//*[@id='SubmitCreate']")
  private WebElement btnCreateAccount;
  //title mrs
  @FindBy(xpath="//*[@id=\'id_gender2\']")
  private WebElement checkTitleMrs;
  //title mr
  @FindBy(xpath="//*[@id=\'id_gender1\']")
  private WebElement checkTitleMr;
  //first name
  @FindBy(xpath="//*[@id=\'customer_firstname\']")
  private WebElement txtFirstName;
  //last name
  @FindBy(xpath="//*[@id=\'customer_lastname\']")
  private WebElement txtLastName;
  //email
  @FindBy(xpath="//*[@id=\'email\']")
  private WebElement txtEmail;
  //password
  @FindBy(xpath="//*[@id=\'passwd\']")
  private WebElement txtPassword;
  //day of birth
  @FindBy(xpath="//*[@id=\'days\']")
  private WebElement txtDayOfBirth;
  //month of birth
  @FindBy(xpath="//*[@id=\'months\']")
  private WebElement txtMonthOfBirth;
  //year of birth
  @FindBy(xpath="//*[@id=\'years\']")
  private WebElement txtYearOfBirth;
  //newsletter
  @FindBy(xpath="//*[@id=\'newsletter\']")
  private WebElement checkNewsletter;
  //special offer
  @FindBy(xpath="//*[@id=\'optin\']")
  private WebElement checkSpecialOffer;

  //ADDRESS
  //first name
  @FindBy(xpath="//*[@id=\'firstname\']")
  private WebElement txtAddressFirstName;
  //last name
  @FindBy(xpath="//*[@id=\'lastname\']")
  private WebElement txtAddressLastName;
  //company
  @FindBy(xpath="//*[@id=\'company\']")
  private WebElement txtCompany;
  //address
  @FindBy(xpath="//*[@id=\'address1\']")
  private WebElement txtAddress;
  //address line 2
  @FindBy(xpath="//*[@id=\'address2\']")
  private WebElement txtAddressLine2;
  //country
  @FindBy(xpath="//*[@id=\'id_country\']")
  private WebElement txtCountry;
  //city
  @FindBy(xpath="//*[@id=\'city\']")
  private WebElement txtCity;
  //state
  @FindBy(xpath="//*[@id=\'id_state\']")
  private WebElement txtState;
  //zipcode
  @FindBy(xpath="//*[@id=\'postcode\']")
  private WebElement txtZipCode;

  //additional information
  @FindBy(xpath="//*[@id=\'other\']")
  private WebElement txtAdditionalInformation;
  //home phone
  @FindBy(xpath="//*[@id=\'phone\']")
  private WebElement txtHomePhone;
  //mobile phone
  @FindBy(xpath="//*[@id=\'phone_mobile\']")
  private WebElement txtMobilePhone;
  //address alias
  @FindBy(xpath="//*[@id=\'alias\']")
  private WebElement txtAddressAlias;
  //button register
  @FindBy(xpath="//*[@id=\"submitAccount\"]")
  private WebElement btnRegister;
  //verify if user is logged in
  @FindBy(xpath="//div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a/span")
  private WebElement userNameNSurname;

  //email
  @FindBy(xpath="//*[@id=\'email\']")
  private WebElement txtLoginEmail;
  //password
  @FindBy(xpath="//*[@id=\'passwd\']")
  private WebElement txtLoginPassword;
  //button login
  @FindBy(xpath="//*[@id=\'SubmitLogin\']")
  private WebElement btnLogIn;
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

  public RegisterNewUserPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    Utils utils = new Utils();
    log = utils.initLogger();
  }

  public void clickBtnSignIn() throws NoSuchElementException {
    Assert.assertNotNull(btnSignIn);
    btnSignIn.click();
  }

  public void setTxtNewEmail(String newEmail) throws NoSuchElementException {
    Assert.assertNotNull(txtNewEmail);
    txtNewEmail.sendKeys(newEmail);
  }

  public void clickBtnCreateAccount() throws NoSuchElementException {
    Assert.assertNotNull(btnCreateAccount);
    btnCreateAccount.click();
  }

  public void clickCheckTitleMrs() throws NoSuchElementException {
    Assert.assertNotNull(checkTitleMrs);
    checkTitleMrs.click();
  }

  public void clickCheckTitleMr() throws NoSuchElementException {
    Assert.assertNotNull(checkTitleMr);
    checkTitleMr.click();
  }

  public void setTxtFirstName(String firstname) throws NoSuchElementException {
    Assert.assertNotNull(txtFirstName);
    txtFirstName.sendKeys(firstname);
  }

  public void setTxtLastName(String lastname) throws NoSuchElementException {
    Assert.assertNotNull(txtLastName);
    txtLastName.sendKeys(lastname);
  }

  public void setTxtEmail(String email) throws NoSuchElementException {
    Assert.assertNotNull(txtEmail);
    txtEmail.clear();
    txtEmail.sendKeys(email);
  }

  public void setTxtPassword(String password) throws NoSuchElementException {
    Assert.assertNotNull(txtPassword);
    txtPassword.clear();
    txtPassword.sendKeys(password);
  }

  public void setTxtDayOfBirth(String dayOfBirth) throws NoSuchElementException {
    Assert.assertNotNull(txtDayOfBirth);
    txtDayOfBirth.sendKeys(dayOfBirth);
  }

  public void setTxtMonthOfBirth(String monthOfBirth) throws NoSuchElementException {
    Assert.assertNotNull(txtMonthOfBirth);
    txtMonthOfBirth.sendKeys(monthOfBirth);
  }

  public void setTxtYearOfBirth(String yearOfBirth) throws NoSuchElementException {
    Assert.assertNotNull(txtYearOfBirth);
    txtYearOfBirth.sendKeys(yearOfBirth);
  }

  public void clickCheckNewsletter() throws NoSuchElementException {
    Assert.assertNotNull(checkNewsletter);
    checkNewsletter.click();
  }

  public void clickCheckSpecialOffer() throws NoSuchElementException {
    Assert.assertNotNull(checkSpecialOffer);
    checkSpecialOffer.click();
  }

  public void setTxtAddressFirstName(String AddressFirstName) throws NoSuchElementException {
    Assert.assertNotNull(txtAddressFirstName);
    txtAddressFirstName.clear();
    txtAddressFirstName.sendKeys(AddressFirstName);
  }

  public void setTxtAddressLastName(String AddressLastName) throws NoSuchElementException {
    Assert.assertNotNull(txtAddressLastName);
    txtAddressLastName.clear();
    txtAddressLastName.sendKeys(AddressLastName);
  }

  public void setTxtCompany(String company) throws NoSuchElementException {
    Assert.assertNotNull(txtCompany);
    txtCompany.sendKeys(company);
  }

  public void setTxtAddress(String address) throws NoSuchElementException {
    Assert.assertNotNull(txtAddress);
    txtAddress.sendKeys(address);
  }

  public void setTxtAddressLine2(String addressLine2) throws NoSuchElementException {
    Assert.assertNotNull(txtAddressLine2);
    txtAddressLine2.sendKeys(addressLine2);
  }

  public void setTxtCountry(String country) throws NoSuchElementException {
    Assert.assertNotNull(txtCountry);
    txtCountry.sendKeys(country);
  }

  public void setTxtCity(String city) throws NoSuchElementException {
    Assert.assertNotNull(txtCity);
    txtCity.sendKeys(city);
  }

  public void setTxtState(String state) throws NoSuchElementException {
    Assert.assertNotNull(txtState);
    txtState.sendKeys(state);
  }

  public void setTxtZipCode(String zipCode) throws NoSuchElementException {
    Assert.assertNotNull(txtZipCode);
    txtZipCode.sendKeys(zipCode);
  }

  public void setTxtAdditionalInformation(String additionalInformation) throws NoSuchElementException {
    Assert.assertNotNull(txtAdditionalInformation);
    txtAdditionalInformation.sendKeys(additionalInformation);
  }

  public void setTxtHomePhone(String phone) throws NoSuchElementException {
    Assert.assertNotNull(txtHomePhone);
    txtHomePhone.sendKeys(phone);
  }

  public void setTxtMobilePhone(String phone) throws NoSuchElementException {
    Assert.assertNotNull(txtMobilePhone);
    txtMobilePhone.sendKeys(phone);
  }

  public void setTxtAddressAlias(String AddressAlias) throws NoSuchElementException {
    Assert.assertNotNull(txtAddressAlias);
    txtAddressAlias.sendKeys(AddressAlias);
  }

  public void clickBtnRegister() throws NoSuchElementException {
    Assert.assertNotNull(btnRegister);
    btnRegister.click();
  }

  public String getUserNameNSurname() throws NoSuchElementException {
    Assert.assertNotNull(userNameNSurname);
    return userNameNSurname.getText();
  }
}
