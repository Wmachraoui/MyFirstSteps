package main.Pages;

import main.java.commun.ApplicationCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BascketPage  extends ApplicationCommon {
    WebDriver driver ;
    By TotalPrice = By.cssSelector("td.product-subtotal > span:nth-child(1)");
    By Priceunitaireselector = By.cssSelector("td.product-price > span:nth-child(1)");
    By basketiconeSelector = By.cssSelector(".wpmenucartli");//shop icon
    By Quantityselector = By.cssSelector("input.input-text:nth-child(1)");
    By Quantityselector2 = By.cssSelector(".cartcontents");
    By addToCartSelector = By.xpath("//li[1]/a[. = 'Add to basket']");
    By Bascketselector = By.cssSelector(".cartcontents");
    By articleviewSelector = By.cssSelector("[title='View Basket']");
    By Delectarticl = By.cssSelector(".remove");
    By delectmessage = By.cssSelector(".woocommerce-message");
    By updatebascket = By.cssSelector("input.button:nth-child(2)");
    By Taxes_selector = By.cssSelector(".tax-rate > td:nth-child(2) > span:nth-child(1)");
    By Prix_total_selector = By.cssSelector(".order-total > td:nth-child(2) > strong:nth-child(1) > span:nth-child(1)");
    By Checkout_Basket_selector = By.cssSelector(".checkout-button");

    public  BascketPage(WebDriver driver){
        this.driver=driver;

    }
    public BascketPage delectFrombascket () {

       driver.findElement(Delectarticl).click();
      //  cliquerElement(Delectarticl,"delet articl");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(delectmessage));

        return this ;
    }
    public String getmessage (){
        return driver.findElement(delectmessage).getText();
    }
    public  String getPriceunitaire(){

        return driver.findElement(Priceunitaireselector).getText();
    }

    public  String getQuantity(){

        return driver.findElement(Quantityselector2).getText();
    }
    public  String getTotalPrice(){

        return driver.findElement(Prix_total_selector).getText();
    }
    public String getTaxes () {

        return driver.findElement(Taxes_selector).getText();

    }
    public MyPaimentPage checkout_Bascket (){

        driver.findElement(Checkout_Basket_selector).click();
        return new MyPaimentPage(driver)  ;


    }
    public BascketPage modifQuantity (String quantity) {

        driver.findElement(Quantityselector).clear();
        driver.findElement(Quantityselector).sendKeys(quantity);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(updatebascket));
      /*driver.findElement((updatebascket)).click();
      WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(timeout));
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(updatebascket));*/

        return this;
    }
    public String getNewArticlnumber () {

        return driver.findElement(Quantityselector).getText();

    }

}
