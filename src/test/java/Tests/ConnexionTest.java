package test.java.Tests;

import main.Pages.ConnexionPage;
import main.Pages.DashbordPage;
import main.Pages.MyemailPage;
import main.Pages.PageDacceuil;
import main.java.commun.JddInscri;
import main.java.commun.SetupTearDown;
import main.java.commun.JddLogin;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

;import java.lang.reflect.Method;

import static main.java.commun.Constants.*;
import static test.java.utils.ExtentReports.ExtentTestManager.startTest;

public class ConnexionTest extends SetupTearDown {


    @Test(dataProvider = "excelDataIns", dataProviderClass = JddInscri.class, priority = 1, description = "Invalid connexion Scenario with wrong username or password.")
    public void TestconnexionFailed(String user, String PWD, Method method) {
        startTest(method.getName(), "Invalid connexion Scenario with wrong username or password.");
        LOG.info("injection de mes jeux de données");
        ConnexionPage connexionPage = new ConnexionPage(driver);
        connexionPage.seconnecter(user, PWD);
        LOG.info("connexion impossible avec des idenfiants inncorecte");
       // dashbordPage.deconnexion();
        String verif = "Hello";
        String msg = connexionPage.getConnexionFailed();
        Assert.assertTrue(msg.contains(verif));
        System.out.println(connexionPage.getConnexionFailed());
        System.out.println("hello");
    }

    @Test(priority = 0, description = "Valid Login Scenario with right username and password.")
    public void TestconnexionDone(Method method) {
        startTest(method.getName(), "valid Login Scenario with invalid username and password.");
        LOG.info("connexion avec des coordonees valides ");
        ConnexionPage connexionPage = new ConnexionPage(driver);
        DashbordPage dashbordPage = connexionPage.seconnecter(login, mdp);
         Assert.assertTrue(dashbordPage.getConnexionDone().contains("Log"));
        LOG.info("Je suis connecté et je suis au DashbordPage");
    }

    @Test(priority = 0, description = "Test De Logout")
    public void TestDeDeconnexion(Method method) {
        startTest(method.getName(), "Test De Logout");
        LOG.info("je suis dans la page dashbord");
        ConnexionPage connexionPage = new ConnexionPage(driver);
        connexionPage.seconnecter1(login, mdp).deconnexion();
        LOG.info("Deconnexion effectué est je suis sur la page de connexion");
    }

    @Test(priority = 1, description = "Login is Present")
    public void logoPresent(Method method) {
        startTest(method.getName(), "Login is Present");
        PageDacceuil pageDacceuil = new PageDacceuil(driver);
        pageDacceuil.logoPresent();
        Assert.assertTrue(pageDacceuil.logoPresent(), "logo est present");
        LOG.info("logo is displayed");
    }

    @Test(priority = 2, description = "Tester le boutton RememberME")

    public void TestRememberme(Method method) {
        startTest(method.getName(), "Login is Present");
        LOG.info("connexion avec des coordonees valides ");
        ConnexionPage connexionPage = new ConnexionPage(driver);
        LOG.info("fermer the Present Tab et ouvrir une 2éme");
        DashbordPage dashbordPage = connexionPage.RememberMe(login, mdp);
        Assert.assertTrue(dashbordPage.getConnexionDone().contains("Log"));
        LOG.info("Je suis toujours connecté");
    }

    @Test
    public void LostMyPawd() {
        ConnexionPage connexionPage = new ConnexionPage(driver);
        MyemailPage myemailPage = connexionPage.LostPawd(sendmypassword);

    }
}
