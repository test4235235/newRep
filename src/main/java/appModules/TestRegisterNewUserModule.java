package appModules;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.RegisterNewUserPage;
import utilities.MsExcelUtility;
import utilities.Utils;

public class TestRegisterNewUserModule {
  private static Logger log;
  private RegisterNewUserPage registerNewUserPage;
  private MsExcelUtility excelUtility;
  private String userNameSurname;

  public TestRegisterNewUserModule(WebDriver driver){
    Utils utils = new Utils();
    log = utils.initLogger();
    log.info("\n\nStart - test module login page");
    registerNewUserPage = new RegisterNewUserPage(driver);
    excelUtility = new MsExcelUtility();
  }

  public boolean createNewUser(WebDriver d, String path, String sheetName) throws Exception{
    try {
      //click sign in
      registerNewUserPage.clickBtnSignIn();
      excelUtility.setExcelFile(path, sheetName);
      //enter e-mail
      String mail = excelUtility.getCellData(1, 0);
      registerNewUserPage.setTxtNewEmail(mail.equals("") ? "test"+System.currentTimeMillis()+"@o2.pl":mail);
      log.info("login - " + (mail.equals("") ? "test"+System.currentTimeMillis()+"@o2.pl":mail));
      //click "Create an account"
      registerNewUserPage.clickBtnCreateAccount();
      String personTitle = excelUtility.getCellData(1, 1);
      if(personTitle.equals("Mrs")) {
        //title mrs
        registerNewUserPage.clickCheckTitleMrs();
      }else if(personTitle.equals("Mr")) {
        //title mr
        registerNewUserPage.clickCheckTitleMr();
      }
      //first name
      String firstName = excelUtility.getCellData(1, 2);
      registerNewUserPage.setTxtFirstName(firstName.equals("") ? "Anastazy" : firstName);
      //last name
      String lastName = excelUtility.getCellData(1, 3);
      registerNewUserPage.setTxtLastName(lastName.equals("") ? "Malniak" : lastName);
      userNameSurname = (firstName.equals("") ? "Anastazy" : firstName) + " " + (lastName.equals("") ? "Malniak" : lastName);
      //email
      registerNewUserPage.setTxtEmail(mail.equals("") ? "test"+System.currentTimeMillis()+"@o2.pl":mail);
      //password
      String password = excelUtility.getCellData(1, 4);
      registerNewUserPage.setTxtPassword(password.equals("") ? "Anastazy123" : password);
      log.info("password - " + (password.equals("") ? "Anastazy123" : password));
      //day of birth
      String birthDay = excelUtility.getCellData(1, 5);
      registerNewUserPage.setTxtDayOfBirth(birthDay.equals("") ? "1":birthDay);
      //month of birth
      String birthMonth = excelUtility.getCellData(1, 6);
      registerNewUserPage.setTxtMonthOfBirth(birthMonth.equals("")?"March":birthMonth);
      //year of birth
      String birthYear = excelUtility.getCellData(1, 7);
      registerNewUserPage.setTxtYearOfBirth(birthYear.equals("")?"1982":birthYear);
      //newsletter
      String isNewsletter = excelUtility.getCellData(1, 8);
      if(isNewsletter.equals("yes")) {
        registerNewUserPage.clickCheckNewsletter();
      }
      //special offer
      String isSpecialOffer = excelUtility.getCellData(1, 9);
      if(isSpecialOffer.equals("yes")) {
        registerNewUserPage.clickCheckSpecialOffer();
      }

      //ADDRESS
      //first name
      registerNewUserPage.setTxtAddressFirstName(firstName.equals("")?"Anastazy":firstName);
      //last name
      registerNewUserPage.setTxtAddressLastName(lastName.equals("")?"Maliniak":lastName);
      //company
      String company = excelUtility.getCellData(1, 10);
      registerNewUserPage.setTxtCompany(company.equals("")?"none":company);
      //address
      String address = excelUtility.getCellData(1, 11);
      registerNewUserPage.setTxtAddress(address.equals("")?"1 New Orchard Road":address);
      //address line 2
      String addressLine2 = excelUtility.getCellData(1, 12);
      registerNewUserPage.setTxtAddressLine2(addressLine2.equals("")?"Armonk, New York 10504-1722":addressLine2);
      //country
      String country = excelUtility.getCellData(1, 13);
      registerNewUserPage.setTxtCountry(country.equals("")?"United States":country);
      //city
      String city = excelUtility.getCellData(1, 14);
      registerNewUserPage.setTxtCity(city.equals("")?"New York":city);
      //state
      String state = excelUtility.getCellData(1, 15);
      registerNewUserPage.setTxtState(state.equals("")?"New York":state);

      //zipcode
      String zipCode = excelUtility.getCellData(1, 16);
      registerNewUserPage.setTxtZipCode(zipCode.equals("")?"10504":zipCode);
      //additional information
      String additionalInfo = excelUtility.getCellData(1, 17);
      registerNewUserPage.setTxtAdditionalInformation(additionalInfo.equals("")?"test":additionalInfo);
      //home phone
      String homePhone = excelUtility.getCellData(1, 18);
      registerNewUserPage.setTxtHomePhone(homePhone.equals("")?"914-499-1900":homePhone);

      //mobile phone
      String mobilePhone = excelUtility.getCellData(1, 19);
      registerNewUserPage.setTxtMobilePhone(mobilePhone.equals("")?"691891726":mobilePhone);

      //address alias
      String addressAlias = excelUtility.getCellData(1, 20);
      registerNewUserPage.setTxtAddressAlias(addressAlias.equals("")?"anastazy123":addressAlias);

      //button register
      registerNewUserPage.clickBtnRegister();
      d.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

      //verify if user is logged in
      String uname = registerNewUserPage.getUserNameNSurname();
      Assert.assertEquals(uname, firstName + " " + lastName);
      return true;
    }catch(Exception e){
      log.info("Exception occured", e);
      throw (e);
    }
  }

  public String getUserNameSurname() {
    return userNameSurname;
  }
}
