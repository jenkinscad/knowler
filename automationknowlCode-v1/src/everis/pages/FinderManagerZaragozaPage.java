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

public class FinderManagerZaragozaPage {
    private By ManagerZaragoza = By.xpath("//*[@id='search-input']");
    private By FinderManagerZaragoza1 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public FinderManagerZaragozaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public FinderManagerZaragozaPage setManagerZaragoza(String value){
        driver.findElement(ManagerZaragoza).clear();
        driver.findElement(ManagerZaragoza).sendKeys(value);
        
        return this;
    }
    public FinderManagerZaragozaPage clickFinderManagerZaragoza1(){
        driver.findElement(FinderManagerZaragoza1).click();
        return this;
    }
    
    
}