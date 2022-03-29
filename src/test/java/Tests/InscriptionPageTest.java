package test.java.Tests;

import main.Pages.DashbordPage;
import main.Pages.InscriptionPage;
import main.java.commun.JddInscri;
import main.java.commun.SetupTearDown;
import main.java.commun.JddLogin;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class InscriptionPageTest extends SetupTearDown {
    @Test(dataProvider = "excelDataIns", dataProviderClass = JddInscri.class ,priority = 1, description = "Invalid inscription Scenario with wrong username or password.")

    public void Testdinscription(String login, String mdp, Method method) {
        LOG.info("aller a la page d'inscription");
        InscriptionPage inscriptionPage = new InscriptionPage(driver);
        LOG.info("je suis dans la page d'inscription");
        DashbordPage dashbordPage = inscriptionPage.inscription(login, mdp);
        LOG.info("Inscription Failed");
        dashbordPage.deconnexion();
        LOG.info("Inscription done");


    }
}
