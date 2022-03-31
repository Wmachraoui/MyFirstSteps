package main.Pages;

import main.java.commun.ApplicationCommon;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ConnexionPage extends ApplicationCommon {

    By usernameselector = By.id("username");
    By password = By.cssSelector("#password");
    By Buttonseconnecter = By.cssSelector("[name=login]");
    By Accountselector = By.cssSelector("#menu-item-50 > a");
    By logoselector = By.cssSelector("#site-logo > a > img");
    By Rememberlink = By.cssSelector("#rememberme");
    By LostPwd = By.cssSelector("#customer_login > div.u-column1.col-1 > form > p.woocommerce-LostPassword.lost_password > a");
    By ResetPwdButton = By.xpath("//*[@id=\"page-36\"]/div/div[1]/form/p[3]/input[2]");
    By ERROR = By.cssSelector(".woocommerce-MyAccount-content > p:nth-child(1)");
    By logOutButton = By.cssSelector("li.woocommerce-MyAccount-navigation-link:nth-child(6) > a:nth-child(1)");

    public ConnexionPage(WebDriver driver) {

        this.driver = driver;

    }


    public DashbordPage seconnecter(String login, String pwd) {

        cliquerElement(Accountselector, "lien pour la page myAccount");
        cliquerElement(Rememberlink,"remember me ");
        saisirTexte(usernameselector, login);
        saisirTexte(password, pwd);
        cliquerElement(Buttonseconnecter, "boutton de connexion");

        System.out.println("ok");
        return new DashbordPage(driver);


    }
    public DashbordPage seconnecter1(String login, String pwd) {
        cliquerElement(Accountselector, "lien pour la page myAccount");
        saisirTexte(usernameselector, login);
        saisirTexte(password, pwd);
        cliquerElement(Buttonseconnecter, "boutton de connexion");
        return new DashbordPage(driver);


    }
    public PageDacceuil logoPresent (){
        boolean logodisplaied= driver.findElement(logoselector).isDisplayed();
        return new PageDacceuil(driver);

    }
    public DashbordPage RememberMe (String login, String pwd){

        cliquerElement(Accountselector, "lien pour la page myAccount");
        cliquerElement(Rememberlink,"remember me ");
        saisirTexte(usernameselector, login);
        saisirTexte(password, pwd);
        cliquerElement(Buttonseconnecter, "boutton de connexion");

        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.linkText("Shop")).sendKeys(selectLinkOpeninNewTab);
        ArrayList<String> tab2=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab2.get(1)).switchTo().window(tab2.get(0)).close();
        driver.switchTo().window(tab2.get(1));
        driver.get("http://practice.automationtesting.in/my-account/");
        return new DashbordPage(driver);
    }
    public MyemailPage LostPawd (String myemail){
        cliquerElement(Accountselector, "lien pour la page myAccount");
        cliquerElement(LostPwd,"lost my password");
        saisirTexte(By.xpath("//*[@id=\"user_login\"]"),myemail);
        cliquerElement(ResetPwdButton,"Reset Pwd");
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.linkText("Shop")).sendKeys(selectLinkOpeninNewTab);
        ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://yopmail.com/fr/wm");
        driver.manage().deleteAllCookies();
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.quit();

        return new MyemailPage(driver);

    }
    public String getConnexionFailed (){
        return driver.findElement(ERROR).getText();
    }


}
