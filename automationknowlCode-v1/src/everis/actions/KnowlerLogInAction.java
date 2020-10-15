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

public class KnowlerLogInAction{
    private By ChangeLanguageMenu = By.xpath("/html/body/main/skmo-app-root/skmo-subheader/div/div/div/div");
    private By SpanishLanguage = By.xpath("/html/body/main/skmo-app-root/skmo-subheader/div/div/div/div[2]/a[1]");
    private By UserName = By.xpath("//*[@id='i0116']");
    private By EnterUser = By.xpath("//*[@id='idSIButton9']");
    private By UserPAssword = By.xpath("//*[@id='i0118']");
    private By EnterPassword = By.xpath("//*[@id='idSIButton9']");
    private By DontStaySigned = By.xpath("//*[@id='idBtn_Back']");
    
    private WebDriver driver;
    private JavascriptExecutor js;
    private Properties prop;
    private String level;
    private KnowlerTest KnowlerTest;
    
    
    
    
    public KnowlerLogInAction(WebDriver driver) throws Exception {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
        prop = new Properties();
        prop.load(new FileInputStream("config.properties"));
        level = prop.getProperty("LOG_LEVEL");
        KnowlerTest = new KnowlerTest();
         
        
    }

    public KnowlerLogInAction GoHomePage () {
        driver.get("https://demo.cloudknowler365.com/home");
        return this;
    }

	public KnowlerLogInAction EnterUser(){
        driver.findElement(UserName).clear();
        driver.findElement(UserName).sendKeys("sergio.perales.vidal@knowler365.com");
        
        driver.findElement(EnterUser).click();
        return this;
    }
    
    public KnowlerLogInAction EnterPassword(){
        driver.findElement(UserPAssword).clear();
        driver.findElement(UserPAssword).sendKeys("365Knowler2");
        
        driver.findElement(EnterPassword).click();
        return this;
    }
    
    public KnowlerLogInAction DontStaySigned(){
        
        driver.findElement(DontStaySigned).click();
        return this;
    }
    
    public KnowlerLogInAction ChangeLanguageMenu(){
        
        driver.findElement(ChangeLanguageMenu).click();
        return this;
    }
    
    public KnowlerLogInAction SpanishLanguage(){
        
        driver.findElement(SpanishLanguage).click();
        return this;
    }
    
    
    public void doKnowlerLogInAction(File folderDownloads, Map<String, WebDriver> contextsDriver, String finalResult, File folderTestCase, String caseName, String handler) throws Exception {
      
      GoHomePage();
      Report.reportLog(finalResult, folderTestCase, caseName,"GoHomePage action completed", "INFO", level, 5000, driver);
      Thread.sleep(5000);
      
      
      EnterUser();
      Report.reportLog(finalResult, folderTestCase, caseName,"EnterUser action completed", "INFO", level, 5000, driver);
      Thread.sleep(5000);
      
      
      EnterPassword();
      Report.reportLog(finalResult, folderTestCase, caseName,"EnterPassword action completed", "INFO", level, 5000, driver);
      Thread.sleep(5000);
      
      
      DontStaySigned();
      Report.reportLog(finalResult, folderTestCase, caseName,"DontStaySigned action completed", "INFO", level, 5000, driver);
      Thread.sleep(5000);
      
      
      ChangeLanguageMenu();
      Report.reportLog(finalResult, folderTestCase, caseName,"ChangeLanguageMenu action completed", "INFO", level, 5000, driver);
      Thread.sleep(5000);
      
      
      SpanishLanguage();
      Report.reportLog(finalResult, folderTestCase, caseName,"SpanishLanguage action completed", "INFO", level, 0, driver);
      
      
    
    }
}