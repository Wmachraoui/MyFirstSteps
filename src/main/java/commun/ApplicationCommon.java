package main.java.commun;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationCommon {
     public WebDriver driver;
    // protected WebDriverWait wait;
     //Log
     protected static final Logger LOG = LoggerFactory.getLogger("ApplicationCommonScript");
     public WebElement verifierVisibiliteElement(By elementLocator) {
          WebElement element;
          WebDriverWait wait = new WebDriverWait(driver,50);
          try {
               element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

          } catch (TimeoutException t) {
               throw new NoSuchElementException("KO");
          }
          return element;
     }
     public void saisirTexte(By elementLocator, String texte){
          verifierVisibiliteElement(elementLocator);
          driver.findElement(elementLocator).clear();
          driver.findElement(elementLocator).sendKeys(texte);
     }
     public void cliquerElement(By elementLocator, String elementName){
          verifierVisibiliteElement(elementLocator);
          driver.findElement(elementLocator).click();
     }
     public WebElement clickableelement (By elementLocator){
         WebElement element;
         WebDriverWait wait = new WebDriverWait(driver,50);
         try {
             element = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));

         } catch (TimeoutException t) {
             throw new NoSuchElementException("KO");
         }
         return element;

     }

    public WebDriver getDriver() {
        return driver;
    }
}
