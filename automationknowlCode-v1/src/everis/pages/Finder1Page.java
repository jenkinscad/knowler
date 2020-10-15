package everis.pages;

import everis.Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class Finder1Page {
    private By EmployeeName = By.xpath("//*[@id='search-input']");
    private By FinderEmployee = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By EmployeeName1 = By.xpath("//*[@id='search-input']");
    private By FinderEmployee1 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By DocNome = By.xpath("//*[@id='search-input']");
    private By FinderDocNome = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public Finder1Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public Finder1Page setEmployeeName(String value){
        driver.findElement(EmployeeName).clear();
        driver.findElement(EmployeeName).sendKeys(value);
        
        return this;
    }
    public Finder1Page clickFinderEmployee(){
        driver.findElement(FinderEmployee).click();
        return this;
    }
    public Finder1Page setEmployeeName1(String value){
        driver.findElement(EmployeeName1).clear();
        driver.findElement(EmployeeName1).sendKeys(value);
        
        return this;
    }
    public Finder1Page clickFinderEmployee1(){
        driver.findElement(FinderEmployee1).click();
        return this;
    }
    public Finder1Page setDocNome(String value){
        driver.findElement(DocNome).clear();
        driver.findElement(DocNome).sendKeys(value);
        
        return this;
    }
    public Finder1Page clickFinderDocNome(){
        driver.findElement(FinderDocNome).click();
        return this;
    }
    
    
}