package main.Pages;

import main.java.commun.ApplicationCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InscriptionPage extends ApplicationCommon {

    By Accountselector = By.cssSelector("#menu-item-50 > a");
    By chooseyourlogin = By.cssSelector("#reg_email");
    By chooseyourpwd = By.cssSelector("#reg_password");
   // By RegisterButton = By.cssSelector(".woocomerce-FormRow > input:nth-child(3)");
    By RegisterButton = By.cssSelector("[name=register]");
     By logoselector = By.cssSelector("#site-logo > a > img");


    By validHome = By.cssSelector(".woocommerce-MyAccount-content");


    public InscriptionPage(WebDriver driver) {
        this.driver = driver;
    }
    public DashbordPage inscription (String login1 ,String mdp){
        cliquerElement(Accountselector,"lien pour la page my Account");
        saisirTexte(chooseyourlogin,login1);
        saisirTexte(chooseyourpwd,mdp);
        cliquerElement(RegisterButton,"button d'inscription");
        return new DashbordPage(driver);



    }
    public PageDacceuil logoPresent (){
      verifierVisibiliteElement(logoselector).click();

      return new PageDacceuil(driver);

    }
}
