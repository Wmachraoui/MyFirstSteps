package test.java.Tests.US8;

import main.Pages.PageDacceuil;
import main.Pages.ProductPage;
import main.java.commun.SetupTearDown;
import org.testng.Assert;
import org.testng.annotations.Test;

import static test.java.utils.ExtentReports.ExtentTestManager.startTest;

public class PRACAUTO_30 extends SetupTearDown {
    @Test
    public void AddArticlFromProductPage() {
        startTest("Add  Articl From  ProductPage ", "practauto 79");
        String expectedArcticleMessage = "has been added to your basket";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        ProductPage productPage = pageDacceuil.clickOnShopage().addToCartByLabel().addTocart();
        Assert.assertTrue(productPage.getAddArticleConfirmationMessage().contains(expectedArcticleMessage));
        // System.out.println(productPage.getHasBeenAddTOBasket());
    }

    @Test
    public void MakeLaQuantiteNull() {
        startTest("Saisir 0 dans le champ 'nombre d'exemplaires' ", "practauto 80");
        String nullArticl = "0";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        ProductPage productPage = pageDacceuil.clickOnShopage().addToCartByLabel().addTocart().addTocartNullArticl(nullArticl);
    }

}
