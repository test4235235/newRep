package stepDefinitions;

import utilities.InitWebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.AfterClass;
import utilities.Utils;


public class LoginFreeCRMStepDefinition extends InitWebDriver {
	private String url;
	public static Logger log;

	public LoginFreeCRMStepDefinition(){
		url = "https://www.freecrm.com/index.html";
		initWebDriver();
		Utils utils = new Utils();
		log = utils.initLogger();
	}

	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page(){
		 log.info("user open web page - " + this.url);
		 wbUtils.openWebPageURL(driver, this.url);
	 }
	
	
	 @When("^title of login page is Free CRM$")
	 public void title_of_login_page_is_free_CRM(){
		 String title = driver.getTitle();
		 log.info("title of web page - " + title);
		 //Assert.assertEquals("Free CRM in the cloud software boosts sales", title);
		 Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
	 }
	
	 //Reg Exp:
	 //1. \"([^\"]*)\"
	 //2. \"(.*)\"
	
	 @Then("^user enters \"(.*)\" and \"(.*)\"$")
	 public void user_enters_username_and_password(String username, String password){
		 log.info("put username and password to login");
		 driver.findElement(By.name("username")).sendKeys(username);
		 driver.findElement(By.name("password")).sendKeys(password);
	 }
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() {
		 log.info("try to click login button");
	 	 WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	 	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 	 js.executeScript("arguments[0].click();", loginBtn);
	 }
	
	
	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page(){
	 	 String title = driver.getTitle();
	 	 log.info("Home Page title ::"+ title);
	 	 Assert.assertEquals("CRMPRO", title);
	 }
	 
	 @Given("^user moves to new contact page$")
	 public void user_moves_to_new_contact_page() {
		 log.info("user move to web page of add new contact");
		 driver.switchTo().frame("mainpanel");
		 Actions action = new Actions(driver);
		 action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		 driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	 }
	 
	 @When("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	 public void user_enters_contacts_details(String firstname, String lastname, String position){
		 log.info("user enter contact details");
		 driver.findElement(By.id("first_name")).sendKeys(firstname);
		 driver.findElement(By.id("surname")).sendKeys(lastname);
		 driver.findElement(By.id("company_position")).sendKeys(position);
		 driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	 }

	 @AfterClass
	public void close_the_browser(){
		log.info("try to close driver and web page");
		driver.close();
	}
}
