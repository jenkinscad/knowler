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

public class FinderProfileAction{
    private By SearchProfileName = By.xpath("//*[@id='search-input']");
    private By FinderProfile = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    
    private WebDriver driver;
    private JavascriptExecutor js;
    private Properties prop;
    private String level;
    private KnowlerTest KnowlerTest;
    
    
    
    
    public FinderProfileAction(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
        prop = new Properties();
        prop.load(new FileInputStream("config.properties"));
        level = prop.getProperty("LOG_LEVEL");
        KnowlerTest = new KnowlerTest();
         
        
    }

    public FinderProfileAction FinderProfile(){
        driver.findElement(SearchProfileName).clear();
        driver.findElement(SearchProfileName).sendKeys("Sergio Perales Vidal");
        
        driver.findElement(FinderProfile).click();
        return this;
    }
    
    
    public void doFinderProfileAction(File folderDownloads, Map<String, WebDriver> contextsDriver, String finalResult, File folderTestCase, String caseName, String handler) throws Exception {
      
      FinderProfile();
      Report.reportLog(finalResult, folderTestCase, caseName,"FinderProfile action completed", "INFO", level, 0, driver);
      
      
    
    }
}