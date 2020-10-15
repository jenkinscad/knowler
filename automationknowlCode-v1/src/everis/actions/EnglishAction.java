package everis.actions;

import everis.Utils;
import everis.report.Report;
import everis.suites.KnowlerTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class EnglishAction{
    private By ChangeLanguageMenuEN = By.xpath("/html/body/main/skmo-app-root/skmo-subheader/div/div/div/div");
    private By EnglishLanguage = By.xpath("/html/body/main/skmo-app-root/skmo-subheader/div/div/div/div[2]/a[2]");
    
    private WebDriver driver;
    private JavascriptExecutor js;
    private Properties prop;
    private String level;
    private KnowlerTest KnowlerTest;
    
    
    
    
    public EnglishAction(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
        prop = new Properties();
        prop.load(new FileInputStream("config.properties"));
        level = prop.getProperty("LOG_LEVEL");
        KnowlerTest = new KnowlerTest();
         
        
    }

    public EnglishAction ChangeLanguageMenuEN(){
        
        driver.findElement(ChangeLanguageMenuEN).click();
        return this;
    }
    
    public EnglishAction EnglishLanguage(){
        
        driver.findElement(EnglishLanguage).click();
        return this;
    }
    
    
    public void doEnglishAction(File folderDownloads, Map<String, WebDriver> contextsDriver, String finalResult, File folderTestCase, String caseName, String handler) throws Exception {
      
      ChangeLanguageMenuEN();
      Report.reportLog(finalResult, folderTestCase, caseName,"ChangeLanguageMenuEN action completed", "INFO", level, 5000, driver);
      Thread.sleep(5000);
      
      
      EnglishLanguage();
      Report.reportLog(finalResult, folderTestCase, caseName,"EnglishLanguage action completed", "INFO", level, 0, driver);
      
      
    
    }
}