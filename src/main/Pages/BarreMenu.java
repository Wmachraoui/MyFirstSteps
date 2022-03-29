package main.Pages;

import main.java.commun.ApplicationCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BarreMenu extends ApplicationCommon {
    By LiendeMyAccount = By.cssSelector("#menu-item-50 > a");
    By LienDeShopPage = By.cssSelector("#menu-item-40 > a");
    By LiendeBasketPage = By.cssSelector(".cartcontents");
    public BarreMenu(WebDriver driver) {
        this.driver = driver;
    }


}
