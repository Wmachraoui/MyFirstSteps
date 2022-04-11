package main.Pages;

import main.java.commun.ApplicationCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashbordPage extends ApplicationCommon {
    WebDriver driver;
    By logOutButton = By.cssSelector("li.woocommerce-MyAccount-navigation-link:nth-child(6) > a:nth-child(1)");
    By usernameselector = By.id("username");
    By password = By.cssSelector("#password");
    By Buttonseconnecter =By.cssSelector("[name=login]");
    By InscriDone = By.cssSelector(".woocommerce-MyAccount-content > p:nth-child(2)");
    By logoselector = By.cssSelector("#site-logo > a > img");
    @FindBy(css = "logOutButton")
    private WebElement  exit ;
    public DashbordPage(WebDriver driver) {
        this.driver = driver;

    }

    public  void deconnexion() {

        //verifierVisibiliteElement(logOutButton);
       //cliquerElement(logOutButton, "button logout is cliquable");
       // ConnexionPage connexionPage = new ConnexionPage(driver);
      //  return new ConnexionPage(driver) ;
      driver.findElement(logOutButton).click();
       // exit.click();

    }
    public PageDacceuil logoPresent (){
        verifierVisibiliteElement(logoselector).click();

        return new PageDacceuil(driver);

    }
    public String getConnexionDone (){
        return driver.findElement(logOutButton).getText();
    }
    public String getInscriptionDone (){
        return driver.findElement(InscriDone).getText();
    }
}
//mvn test terminal