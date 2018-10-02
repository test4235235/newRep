package stepDefinitions;

import utilities.InitWebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import utilities.Utils;


public class GoogleStepDefinition extends InitWebDriver {
    private String url;
    public static Logger log;

    public GoogleStepDefinition(){
        url = "https://www.google.pl/";
        initWebDriver();
        Utils utils = new Utils();
        log = utils.initLogger();
    }

    @Given("^web page with Google search$")
    public void open_Google_webpage(){
        log.info("Try to open web page " + this.url);
        wbUtils.openWebPageURL(driver, this.url);
    }

    @When("^we paste in Google search text field \"(.*)\"$")
    public void paste_Google_search_phrase(String phrase){
        log.info("Try to put phrase in google search text field, phrase " + phrase);
        driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys(Keys.chord(phrase, Keys.ESCAPE));
    }

    @Then("^we search phrase by click search button$")
    public void click_button_search() throws InterruptedException{
        log.info("try to click button google search");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
    }

    @Then("^we check web page title name with phrase \"(.*)\"$")
    public void we_check_web_page_title_name(String phrase){
        String googleWebPageTitle = driver.getTitle();
        log.info("try to get web page title and check if contain searched phrase " + phrase);
        Assert.assertTrue(googleWebPageTitle.equals(phrase + " - Szukaj w Google"), "Title of webpage is random than searched phase");
    }

    @AfterClass
    public void close_browser(){
        log.info("try to close driver and web page");
        driver.close();
    }
}
