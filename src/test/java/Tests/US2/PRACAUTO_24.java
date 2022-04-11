package test.java.Tests.US2;

import main.Pages.ConnexionPage;
import main.Pages.DashbordPage;
import main.Pages.MyemailPage;
import main.java.commun.JddInscri;
import main.java.commun.SetupTearDown;
import org.testng.Assert;
import org.testng.annotations.Test;

;import java.lang.reflect.Method;

import static main.java.commun.Constants.*;
import static test.java.utils.ExtentReports.ExtentTestManager.startTest;

public class PRACAUTO_24 extends SetupTearDown {

//Ajouter les liens avec Jira

    /**
     * Le Test suivant conteient les cas de Test :
     *
     * @param user
     * @param PWD
     * @param method
     */
    @Test(dataProvider = "excelDataIns", dataProviderClass = JddInscri.class, priority = 1, description = "Invalid connexion Scenario with wrong username or password.")
    public void TestconnexionFailed(String user, String PWD, Method method) {
        LOG.info("PracAuto-62 ,PracAuto-55,PracAuto-57 start");
        startTest(method.getName(), "PracAuto-62 ,PracAuto-55,PracAuto-57");
        LOG.info("injection de mes jeux de données");
        ConnexionPage connexionPage = new ConnexionPage(driver);
        connexionPage.seconnecter(user, PWD);
        LOG.info("connexion impossible avec des idenfiants inncorecte");
        String verif = "Hello";
        String msg = connexionPage.getConnexionFailed();
        Assert.assertTrue(msg.contains(verif));
    }

    /**
     * Le Test suivant
     *
     * @param method
     */

    @Test(priority = 0, description = "Valid Login Scenario with right username and password.")
    public void TestconnexionDone(Method method) {
        LOG.info("PracAuto-67 Start");
        startTest(method.getName(), "PracAuto-67");
        LOG.info("connexion avec des coordonees valides ");
        ConnexionPage connexionPage = new ConnexionPage(driver);
        DashbordPage dashbordPage = connexionPage.seconnecter(login, mdp);
        Assert.assertTrue(dashbordPage.getConnexionDone().contains("Log"));
        LOG.info("Je suis connecté et je suis au DashbordPage");
    }

    /**
     * Le Test suivant nous permet de verifier si le boutton RemberME
     * est active
     *
     * @param method
     */

    @Test(priority = 2, description = "Tester le boutton RememberME")

    public void TestRememberme(Method method) {
        LOG.info("PracAuto-68 Start");
        startTest("Test Remember me", "PracAuto-68");
        LOG.info("connexion avec des coordonees valides ");
        ConnexionPage connexionPage = new ConnexionPage(driver);
        LOG.info("fermer the Present Tab et ouvrir une 2éme");
        DashbordPage dashbordPage = connexionPage.RememberMe(login, mdp);
        Assert.assertTrue(dashbordPage.getConnexionDone().contains("Log"));
        LOG.error("Je suis toujours connecté");
    }

    /**
     * Le Test suivant
     */
    @Test
    public void LostMyPawd() {
        LOG.info("PracAuto :    start");
        ConnexionPage connexionPage = new ConnexionPage(driver);
        MyemailPage myemailPage = connexionPage.LostPawd(sendmypassword);

    }
}
