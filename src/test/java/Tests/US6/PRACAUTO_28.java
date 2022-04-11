package test.java.Tests.US6;

import main.Pages.ConnexionPage;
import main.java.commun.SetupTearDown;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static main.java.commun.Constants.login;
import static main.java.commun.Constants.mdp;
import static test.java.utils.ExtentReports.ExtentTestManager.startTest;

public class PRACAUTO_28 extends SetupTearDown {
    /**
     * Le Test suivant
     *
     * @param method
     */

    @Test(priority = 0, description = "Test De Logout")
    public void TestDeDeconnexion(Method method)  {
        LOG.info("PracAuto-50 Start");
        startTest("Test De Deconnexion", "PracAuto-50");
        LOG.info("je suis dans la page dashbord");
        ConnexionPage connexionPage = new ConnexionPage(driver);
        connexionPage.seconnecter1(login, mdp).deconnexion();
        LOG.info("Deconnexion effectué est je suis sur la page de connexion");
    }
}
