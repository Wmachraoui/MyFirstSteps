package main.java.commun;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SetupTearDown extends ApplicationCommon {
    public static Properties prop;

    @BeforeMethod
    public void setup() throws Exception {
        BasicConfigurator.configure();
        //  System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        //  System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");

        Properties prop = new Properties();
        FileInputStream objfile = new FileInputStream(
                System.getProperty("user.dir") + "\\test.properties");
        prop.load(objfile);
        //browser
        String browsern = prop.getProperty("browser");
        //url
        String url = prop.getProperty("url");
        //////////////////////////Check if parameter passed  is 'firefox'///////////////////
        if (browsern.equalsIgnoreCase("FF")) {

            driver = new FirefoxDriver();
            LOG.info("FIREFOX is OPEN");
            driver.manage().window().maximize();
            driver.get(url);
            //////////////////////Check if parameter passed  is 'EDGE' ////////////////////
        } else if (browsern.equalsIgnoreCase("ED")) {

            driver = new EdgeDriver();
            LOG.info("MICROSOFT EDGE is OPEN");
            driver.manage().window().maximize();
            driver.get(url);
            /////////////Check if parameter passed  is 'CHROME'//////////////////////////
        } else if (browsern.equalsIgnoreCase("CH")) {

            driver = new ChromeDriver();
            LOG.info("CHROME IS OPEN");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.get(url);


        }
    }
    @AfterMethod
    public void quit() {
        driver.quit();
        LOG.info("Browser is close");
    }
}
