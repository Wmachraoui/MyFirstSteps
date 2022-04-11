package test.java.Tests.US7;

import main.Pages.PageDacceuil;
import main.Pages.ProductPage;
import main.Pages.ShopPage;
import main.java.commun.SetupTearDown;
import org.testng.Assert;
import org.testng.annotations.Test;

import static test.java.utils.ExtentReports.ExtentTestManager.startTest;

public class PRACTAUTO_29 extends SetupTearDown {

    @Test
    public void addArticleToCart() {
        startTest("add  Article To Cart ", "practauto 85");
        String expectedArcticlePrice = "View Basket";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        ShopPage shopPage = pageDacceuil.
                clickOnShopage()
                .AddArticleToBascket();
        Assert.assertTrue(shopPage.getViewArticleProductMessage().contains(expectedArcticlePrice));
    }

    @Test
    public void addArticleToCartByImage() {
        startTest("add Article To Cart By Image", "practauto 85");
        String expectedArcticle = "has been added to your basket";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        ProductPage productPage = pageDacceuil.
                clickOnShopage()
                .addToCartByImage();
        Assert.assertTrue(productPage.getArticleDescriptif().contains(expectedArcticle));
    }

    @Test
    public void addArticleToCartFromShopage() {
        startTest("add Article To Cart From Shopage", "practauto 84");
        String expectedArcticleMessage = "View Basket";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        ShopPage shopPage = pageDacceuil.clickOnShopage();
        shopPage.AddArticleToBascket().getViewArticleProductMessage();
        String actualArcticleMessage = shopPage.getViewArticleProductMessage();
        Assert.assertTrue(actualArcticleMessage.contains(expectedArcticleMessage));
    }

    @Test
    public void addArticleToCartByLabel() {
        startTest("add Article To Cart By Label", "practauto 86");
        String expectedArcticleMessage = "has been added to your basket";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        ProductPage productPage = pageDacceuil.
                clickOnShopage()
                .addToCartByLabel().addTocart();
       // Assert.assertTrue(productPage.getAddArticleConfirmationMessage().contains(expectedArcticleMessage));
    }

    @Test
    public void addArticleToCartByPrice() {
        startTest("add Article To Cart By Price", "practauto 87");
        String expectedArcticleMessage = "has been added to your basket";
        String expectedArticleDetails = "This guide introduces the";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        ProductPage productPage = pageDacceuil.
                clickOnShopage()
                .addToCartByPrice().addTocart();

        String actualArticleDetails = productPage.getArticleDescriptif();
        String actualArticleMessage = productPage.getAddArticleConfirmationMessage();

        Assert.assertTrue(actualArticleMessage.contains(expectedArcticleMessage));
        Assert.assertTrue(actualArticleDetails.contains(expectedArticleDetails));
    }

    @Test
    public void verifyFilterByTheme()  {
        startTest("verify Filter By Theme", "pracauto 88");
        String expectedAndroidCat = "Android";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        ShopPage shopPage = pageDacceuil.clickOnShopage().shopFilterbyTheme();
        shopPage.getshopFilterbyTheme();
        Assert.assertTrue(shopPage.getshopFilterbyTheme().contains(expectedAndroidCat));

    }

    @Test
    public void verifyFilterByPrice1() {

        startTest("verify Filter By Price1", "pracauto 88");
        int expectePprice = 30000;

        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        ShopPage shopPage = pageDacceuil.clickOnShopage().shopFilterByPrice();
        shopPage.getFilterArticle(expectePprice);
        Assert.assertTrue(shopPage.getFilterArticle(expectePprice));

    }
    @Test
    public void verifyViewBasket()  {
        startTest("verify View Basket", "pracauto 88");
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        boolean isbasasketpresent = pageDacceuil.clickOnShopage().isbasketPresent();
        Assert.assertTrue(isbasasketpresent);
    }
    @Test
    public void SaleArticlePresent() {
        startTest("Sale Article Present", "pracauto 88");
        String expectedFirsArticle = "Android Quick Start Guide";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        ShopPage shopPage = pageDacceuil.clickOnShopage().AddArticleToBascket();
        Assert.assertTrue(shopPage.getArticle().contains(expectedFirsArticle));

    }


}
