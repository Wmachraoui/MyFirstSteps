package test.java.Tests;

import main.Pages.DashbordPage;
import main.Pages.InscriptionPage;
import main.java.commun.JddInscri;
import main.java.commun.SetupTearDown;
import main.java.commun.JddLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static main.java.commun.Constants.loginInscriptionvalid;
import static main.java.commun.Constants.mdpInscriptionvalid;
import static test.java.utils.ExtentReports.ExtentTestManager.startTest;

public class InscriptionPageTest extends SetupTearDown {
    @Test(dataProvider = "excelData", dataProviderClass = JddLogin.class ,priority = 1, description = "Invalid inscription Scenario with wrong username or password.")

    public void TestdinscriptionFailed(String login, String mdp, Method method) {
        startTest(method.getName(), "Invalid inscription Scenario with wrong username or password.");
        LOG.info("aller a la page d'inscription");
        InscriptionPage inscriptionPage = new InscriptionPage(driver);
        LOG.info("je suis dans la page d'inscription");
        inscriptionPage.inscriptionFailed(login, mdp);
        LOG.info("Inscription Failed");
        Assert.assertTrue(inscriptionPage.getinscriptionFailed().contains("Register"));
    }
    @Test(priority =0, description = "valid inscription Scenario with valid username and password.")
        public void TestdinscriptionDone( Method method) {
            startTest(method.getName(), "valid inscription Scenario with valid username and password.");
           InscriptionPage inscriptionPage = new InscriptionPage(driver);
            LOG.info("aller a la page d'inscription");
            DashbordPage dashbordPage = inscriptionPage.inscriptionDone(loginInscriptionvalid,mdpInscriptionvalid);
            LOG.info("je suis dans la page d'inscription");
            Assert.assertTrue(dashbordPage.getInscriptionDone().contains("Log"));
        LOG.info("Inscription Done");
    }
}

