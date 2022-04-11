package main.Pages;

import main.ActionDriver.Action;
import main.java.commun.ApplicationCommon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends ApplicationCommon {
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        Action action = new Action();
    }

    @FindBy(css = "li[id='menu-item-40'] a")
    private WebElement shopSelector;
    @FindBy(css = "//*[@id='content']/ul/li[1]")
    private WebElement firstProductSelector;
    @FindBy(css = "[class='stock in-stock']")
    private WebElement articleStockNumberSelector;
    @FindBy(css = "[itemprop='description']")
    private WebElement articleDescription;
    @FindBy(css = "[itemprop='price']")
    private WebElement articlePrice;
    @FindBy(css = "[class='amount']")
    private WebElement articlePricebasketSelector;
    @FindBy(css = "name='quantity'")
    private WebElement articleQuantity;
    @FindBy(css = ".woocommerce-message")
    private WebElement addConfirmationMessage;
    @FindBy(css = "[class='single_add_to_cart_button button alt']")
    private WebElement addtoCartSelector;
    @FindBy(css = "[title='View Basket']")
    private WebElement articleviewSelector;
    @FindBy(css = ".wpmenucartli")
    private WebElement basketiconeSelector;
    @FindBy(css = ".remove")
    private WebElement deletfromBascket;
    @FindBy(css = ".woocommerce-message")
    private WebElement demetMessage;
    @FindBy(css = ".input-text")
    private WebElement quantitenull;

    Action action = new Action();

    public ProductPage addTocart() {
        addtoCartSelector.click();
        action.fluentWait(driver, basketiconeSelector, 5);
        return this;
    }

    public String getHasBeenAddTOBasket() {

        return addConfirmationMessage.getText();

    }


    public String getArticePrice() {

        return articlePricebasketSelector.getText();
    }

    public String getAricleStock() {

        String ArcticleStock = articleStockNumberSelector.getText();

        return ArcticleStock;

    }

    public String getArticleDescriptif() {
        System.out.println(articleDescription.getText() + "article test");
        return articleDescription.getText();

    }

    public String getAddArticleConfirmationMessage() {

        return addConfirmationMessage.getText();

    }

    public String getArticleQuantity() {

        return articleQuantity.getText();
    }

    public ProductPage addTocartNullArticl(String nullArticl) {
        quantitenull.clear();
        quantitenull.sendKeys();
        addtoCartSelector.click();
        action.fluentWait(driver, basketiconeSelector, 5);
        return this;
    }

}
