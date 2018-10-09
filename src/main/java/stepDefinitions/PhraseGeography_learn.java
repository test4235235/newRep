package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import utilities.InitWebDriver;
import utilities.Utils;

public class PhraseGeography_learn extends InitWebDriver {
    private String url;
    public static Logger log;

    public PhraseGeography_learn(){
        url = "https://www.google.pl/";
        initWebDriver();
        Utils utils = new Utils();
        log = utils.initLogger();
    }

    @Given("^search web page$")
    public void testowyfeature(){
        log.info("Try to open web page " + this.url);
        wbUtils.openWebPageURL(driver, this.url);
    }
    @When("^type in search \"(.*)\"$")
    public void puttextfield(String param){
        log.info("Try to put phrase in google search text field, phrase " + param);
        driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys(Keys.chord(param, Keys.ESCAPE));
    }
    @Then("^click search$")
    public void clickbutton(){
        log.info("try to click button google search");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
    }
    @Then ("^check web page \"(.*)\"$")
    public void checkphrase(String phrase){
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
