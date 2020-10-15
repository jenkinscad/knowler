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

public class FinderEmployeePage {
    private By EmployeeName3 = By.xpath("//*[@id='search-input']");
    private By FinderEmployee3 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By PersonEmployeeName = By.xpath("//*[@id='search-input']");
    private By FinderPersonEmployee = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By EmployeeName4 = By.xpath("//*[@id='search-input']");
    private By FinderEmployee4 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By EmployeeName5 = By.xpath("//*[@id='search-input']");
    private By FinderEmployee5 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By EmployeeName6 = By.xpath("//*[@id='search-input']");
    private By FinderEmployee6 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By EmployeeName7 = By.xpath("//*[@id='search-input']");
    private By FinderEmployee7 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public FinderEmployeePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public FinderEmployeePage setEmployeeName3(String value){
        driver.findElement(EmployeeName3).clear();
        driver.findElement(EmployeeName3).sendKeys(value);
        
        return this;
    }
    public FinderEmployeePage clickFinderEmployee3(){
        driver.findElement(FinderEmployee3).click();
        return this;
    }
    public FinderEmployeePage setPersonEmployeeName(String value){
        driver.findElement(PersonEmployeeName).clear();
        driver.findElement(PersonEmployeeName).sendKeys(value);
        
        return this;
    }
    public FinderEmployeePage clickFinderPersonEmployee(){
        driver.findElement(FinderPersonEmployee).click();
        return this;
    }
    public FinderEmployeePage setEmployeeName4(String value){
        driver.findElement(EmployeeName4).clear();
        driver.findElement(EmployeeName4).sendKeys(value);
        
        return this;
    }
    public FinderEmployeePage clickFinderEmployee4(){
        driver.findElement(FinderEmployee4).click();
        return this;
    }
    public FinderEmployeePage setEmployeeName5(String value){
        driver.findElement(EmployeeName5).clear();
        driver.findElement(EmployeeName5).sendKeys(value);
        
        return this;
    }
    public FinderEmployeePage clickFinderEmployee5(){
        driver.findElement(FinderEmployee5).click();
        return this;
    }
    public FinderEmployeePage setEmployeeName6(String value){
        driver.findElement(EmployeeName6).clear();
        driver.findElement(EmployeeName6).sendKeys(value);
        
        return this;
    }
    public FinderEmployeePage clickFinderEmployee6(){
        driver.findElement(FinderEmployee6).click();
        return this;
    }
    public FinderEmployeePage setEmployeeName7(String value){
        driver.findElement(EmployeeName7).clear();
        driver.findElement(EmployeeName7).sendKeys(value);
        
        return this;
    }
    public FinderEmployeePage clickFinderEmployee7(){
        driver.findElement(FinderEmployee7).click();
        return this;
    }
    
    
}