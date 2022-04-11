package test.java.Tests.US9;

import main.Pages.BascketPage;
import main.Pages.PageDacceuil;
import main.Pages.ProductPage;
import main.java.commun.SetupTearDown;
import org.apache.poi.hssf.util.AreaReference;
import org.testng.Assert;
import org.testng.annotations.Test;

import static test.java.utils.ExtentReports.ExtentTestManager.startTest;

public class PRACAUTO_32 extends SetupTearDown {
    @Test
    public void DeletArticlFromBascket() {
        startTest("Delet Articl  From Bascket", "practauto 96");
        String BascketEmpty = "Android Quick Start Guide removed";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        BascketPage bascketPage = pageDacceuil.clickOnShopage().ModiffromBascket().delectFrombascket();
        String Articlnumber = bascketPage.getmessage();
        Assert.assertTrue(Articlnumber.contains(BascketEmpty), "bascket is Empty");
    }

    @Test
    public void GoToPayement() {
        startTest("Verifier les prix avant d'aller a la page de payement", "practauto 89");
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        BascketPage bascketPage = pageDacceuil.clickOnShopage().ModiffromBascket();
        Assert.assertTrue(bascketPage.getPriceunitaire().contains("₹450.00"));
        Assert.assertTrue(bascketPage.getTaxes().contains("₹22.50"));
        Assert.assertTrue(bascketPage.getTotalPrice().contains("₹472.50"));

        bascketPage.checkout_Bascket();
        LOG.info("je suis a la Page de payement");
    }
    @Test
    public void UpdateNombreDarticles() {
        startTest("Choisir le nombre d'exemplaire", "practauto 97");
        String newquantity = "2";
        String BascketEmpty = "Android Quick Start Guide removed";
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        BascketPage bascketPage = pageDacceuil.clickOnShopage().ModiffromBascket().modifQuantity(newquantity);
        String QuantityLink = bascketPage.getNewArticlnumber();
        System.out.println(QuantityLink);
    }

}