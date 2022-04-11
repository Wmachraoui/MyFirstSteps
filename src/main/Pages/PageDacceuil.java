package main.Pages;


import main.java.commun.ApplicationCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageDacceuil extends ApplicationCommon {
    By logoselector = By.cssSelector("#site-logo > a > img");
    By LienDeShopPage = By.cssSelector("#menu-item-40 > a");
    public PageDacceuil(WebDriver driver) {
        this.driver = driver;
    }

    public boolean logoPresent (){

        boolean logodisplaied= driver.findElement(logoselector).isDisplayed();
       return logodisplaied;

    }
    public ShopPage clickOnShopage(){
        cliquerElement(LienDeShopPage,"Shop");
        return new ShopPage(driver);
    }

}
