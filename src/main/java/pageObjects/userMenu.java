package pageObjects;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Utils;

public class userMenu {
  @FindBy(xpath="//*[@id='block_top_menu']/ul")
  private WebElement topMenu;

  @FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/ul")
  private WebElement subMenu;

  @FindBy(xpath = "//*[@id='selectProductSort']")
  private WebElement selectSortOrder;

  private static Logger log;
  private WebDriver wDriver;

  public userMenu(WebDriver driver) {
    wDriver = driver;
    PageFactory.initElements(wDriver, this);
    Utils utils = new Utils();
    log = utils.initLogger();
  }

  public boolean moveMousePointerOnMenuOption(String nameOption){
    Actions actions = new Actions(wDriver);
    try{
      Assert.assertNotNull(topMenu, "There is no element for top menu");
      List<WebElement> listMenuOptions = topMenu.findElements(By.xpath("./li/a"));
      System.out.println("liczba elementów na liście - " + listMenuOptions.size());
      Assert.assertFalse(listMenuOptions.size() <= 0, "List have more than one element");
      for(WebElement el : listMenuOptions){
        System.out.println("searched - " + nameOption + " ,founded - " + el.getText());
        if(el.getText().equals(nameOption)){
          System.out.println("Option was founded - " + el.getText());
          actions.moveToElement(el).build().perform();
          break;
        }
      }
      return true;
    }catch(Exception e){
      log.info("Exception ", e);
      throw e;
    }
  }

  public boolean selectSubMenuOption(String nameOption){
    Actions actions = new Actions(wDriver);
    try{
      List<WebElement> listSubMenuOptions = subMenu.findElements(By.xpath("./li/a"));
      System.out.println("\n\n\nliczba elementów na liście - " + listSubMenuOptions.size());
      Assert.assertFalse(listSubMenuOptions.size() <= 0, "List have more than one element");
      for(WebElement optSubMenu : listSubMenuOptions){
        System.out.println("searched - " + nameOption + " ,founded - " + optSubMenu.getText());
        if(optSubMenu.getText().equals(nameOption)){
          System.out.println("Option was founded - " + optSubMenu.getText());
          optSubMenu.click();
          break;
        }
      }
      return true;
    }catch(Exception e){
      log.info("Exception ", e);
      throw e;
    }
  }

  public boolean selectSortOrderByValue(String sortValue){
    try{
      List<WebElement> listSortOptions = selectSortOrder.findElements(By.xpath("./option"));
      System.out.println("liczba elementów na liście - " + listSortOptions.size());
      Assert.assertFalse(listSortOptions.size() <= 0, "List have more than one element");
      for(WebElement kindSort : listSortOptions){
        System.out.println("searched - " + sortValue + " ,founded - " + kindSort.getText());
        if(kindSort.getText().equalsIgnoreCase(sortValue)){
          kindSort.click();
        }
      }
      return true;
    }catch(Exception e){
      log.info("Exception ", e);
      throw e;
    }
  }
}
