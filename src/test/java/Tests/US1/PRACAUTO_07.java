package test.java.Tests.US1;

import main.Pages.DashbordPage;
import main.Pages.InscriptionPage;
import main.java.commun.SetupTearDown;
import main.java.commun.JddLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static main.java.commun.Constants.loginInscriptionvalid;
import static main.java.commun.Constants.mdpInscriptionvalid;
import static test.java.utils.ExtentReports.ExtentTestManager.getTest;
import static test.java.utils.ExtentReports.ExtentTestManager.startTest;

public class PRACAUTO_07 extends SetupTearDown {
    /**
     * Le Test suivant
     * @param login
     * @param mdp
     */
    @Test(dataProvider = "excelData", dataProviderClass = JddLogin.class, priority = 1, description = "Us1 tests")

    public void TestdinscriptionFailed(String login, String mdp) {
        LOG.info("PracAuto: 69,61,64,56,58   start");
        startTest("Test d'Inscription invalide", "PRACAUT-O7 Start");
        LOG.info("aller a la page d'inscription");
        InscriptionPage inscriptionPage = new InscriptionPage(driver);
        LOG.info("je suis dans la page d'inscription et l'injection des jeux de données commencent ");
        inscriptionPage.inscriptionFailed(login, mdp);
        LOG.info("Inscription Failed");
        Assert.assertTrue(inscriptionPage.getinscriptionFailed().contains("Register"));
    }

    /**
     * Le Test suivant
     * @param method
     */
    @Test(priority = 0, description = "valid inscription Scenario with valid username and password.")
    public void TestdinscriptionDone(Method method) {
        LOG.info("PracAuto-52,PracAuto-56 Start");
        startTest("Test d'Inscription valide", "valid inscription Scenario with valid username and password.");
        InscriptionPage inscriptionPage = new InscriptionPage(driver);
        LOG.info("aller a la page d'inscription");
        DashbordPage dashbordPage = inscriptionPage.inscriptionDone(loginInscriptionvalid, mdpInscriptionvalid);
        dashbordPage.getInscriptionDone();
        LOG.info("je suis dans la page d'insc");
        String msg="From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.";
        Assert.assertTrue(dashbordPage.getInscriptionDone().contains("msg"));
        LOG.info("Inscription Done");
    }
}

