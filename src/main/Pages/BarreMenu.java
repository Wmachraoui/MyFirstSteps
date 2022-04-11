package main.Pages;

import main.java.commun.ApplicationCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BarreMenu extends ApplicationCommon {
    By LiendeMyAccount = By.cssSelector("#menu-item-50 > a");
    By LienDeShopPage = By.cssSelector("#menu-item-40 > a");
    By LiendeBasketPage = By.cssSelector(".cartcontents");


    public BarreMenu(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clic sur l'onglet MyAccount
     * @return
     */
    public ConnexionPage cliquersurMyAccount (){
        LOG.info("Redirection vers la page 'MyAccount'");
        Actions actions =new Actions(driver);
        actions.moveToElement(driver.findElement(LiendeMyAccount));
    return new ConnexionPage(driver);
    }


}
