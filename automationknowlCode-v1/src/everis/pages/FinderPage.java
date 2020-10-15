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

public class FinderPage {
    private By AssetAssert = By.xpath("//*[@id='search-input']");
    private By Finder = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By ProductoFinder = By.xpath("//*[@id='search-input']");
    private By Finder1 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By DocumentsFromEmployee = By.xpath("//*[@id='search-input']");
    private By FindeDocFromUser = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By AssetAssert1 = By.xpath("//*[@id='search-input']");
    private By Finder2 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By EmployeeName2 = By.xpath("//*[@id='search-input']");
    private By FinderEmployee2 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By ManagerZaragozaAssert = By.xpath("//*[@id='search-input']");
    private By FinderManagerZaragoza = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By DirectorInZaragozaAssert = By.xpath("//*[@id='search-input']");
    private By DirectorZaragoza = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By AssetAssert2 = By.xpath("//*[@id='search-input']");
    private By Finder3 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By Employee = By.xpath("//*[@id='search-input']");
    private By FinderProjects = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By ProjectsJapon = By.xpath("//*[@id='search-input']");
    private By FinderEmpProjectsJapon = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public FinderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public FinderPage setAssetAssert(String value){
        driver.findElement(AssetAssert).clear();
        driver.findElement(AssetAssert).sendKeys(value);
        
        return this;
    }
    public FinderPage clickFinder(){
        driver.findElement(Finder).click();
        return this;
    }
    public FinderPage setProductoFinder(String value){
        driver.findElement(ProductoFinder).clear();
        driver.findElement(ProductoFinder).sendKeys(value);
        
        return this;
    }
    public FinderPage clickFinder1(){
        driver.findElement(Finder1).click();
        return this;
    }
    public FinderPage setDocumentsFromEmployee(String value){
        driver.findElement(DocumentsFromEmployee).clear();
        driver.findElement(DocumentsFromEmployee).sendKeys(value);
        
        return this;
    }
    public FinderPage clickFindeDocFromUser(){
        driver.findElement(FindeDocFromUser).click();
        return this;
    }
    public FinderPage setAssetAssert1(String value){
        driver.findElement(AssetAssert1).clear();
        driver.findElement(AssetAssert1).sendKeys(value);
        
        return this;
    }
    public FinderPage clickFinder2(){
        driver.findElement(Finder2).click();
        return this;
    }
    public FinderPage setEmployeeName2(String value){
        driver.findElement(EmployeeName2).clear();
        driver.findElement(EmployeeName2).sendKeys(value);
        
        return this;
    }
    public FinderPage clickFinderEmployee2(){
        driver.findElement(FinderEmployee2).click();
        return this;
    }
    public FinderPage setManagerZaragozaAssert(String value){
        driver.findElement(ManagerZaragozaAssert).clear();
        driver.findElement(ManagerZaragozaAssert).sendKeys(value);
        
        return this;
    }
    public FinderPage clickFinderManagerZaragoza(){
        driver.findElement(FinderManagerZaragoza).click();
        return this;
    }
    public FinderPage setDirectorInZaragozaAssert(String value){
        driver.findElement(DirectorInZaragozaAssert).clear();
        driver.findElement(DirectorInZaragozaAssert).sendKeys(value);
        
        return this;
    }
    public FinderPage clickDirectorZaragoza(){
        driver.findElement(DirectorZaragoza).click();
        return this;
    }
    public FinderPage setAssetAssert2(String value){
        driver.findElement(AssetAssert2).clear();
        driver.findElement(AssetAssert2).sendKeys(value);
        
        return this;
    }
    public FinderPage clickFinder3(){
        driver.findElement(Finder3).click();
        return this;
    }
    public FinderPage setEmployee(String value){
        driver.findElement(Employee).clear();
        driver.findElement(Employee).sendKeys(value);
        
        return this;
    }
    public FinderPage clickFinderProjects(){
        driver.findElement(FinderProjects).click();
        return this;
    }
    public FinderPage setProjectsJapon(String value){
        driver.findElement(ProjectsJapon).clear();
        driver.findElement(ProjectsJapon).sendKeys(value);
        
        return this;
    }
    public FinderPage clickFinderEmpProjectsJapon(){
        driver.findElement(FinderEmpProjectsJapon).click();
        return this;
    }
    
    
}