package test.java.Tests.US3;

import main.Pages.PageDacceuil;
import main.java.commun.SetupTearDown;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static test.java.utils.ExtentReports.ExtentTestManager.startTest;

public class PRACAUTO_25 extends SetupTearDown {
    /**
     * Le Test suivant
     *
     * @param method
     */

    @Test(priority = 1, description = "Login is Present")
    public void logoPresent(Method method) {
        LOG.info("PracAuto-54 Start");
        startTest(method.getName(), "PracAuto-54");
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        pageDacceuil.logoPresent();
        Assert.assertTrue(pageDacceuil.logoPresent(), "logo est present");
        LOG.info("logo is displayed");
    }
}
