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

public class FinderOrganizationPage {
    private By OrganizationName = By.xpath("//*[@id='search-input']");
    private By FinderOrganization = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public FinderOrganizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public FinderOrganizationPage setOrganizationName(String value){
        driver.findElement(OrganizationName).clear();
        driver.findElement(OrganizationName).sendKeys(value);
        
        return this;
    }
    public FinderOrganizationPage clickFinderOrganization(){
        driver.findElement(FinderOrganization).click();
        return this;
    }
    
    
}