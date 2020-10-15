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

public class FinderAssetPage {
    private By AssetName = By.xpath("//*[@id='search-input']");
    private By FinderAsset = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public FinderAssetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public FinderAssetPage setAssetName(String value){
        driver.findElement(AssetName).clear();
        driver.findElement(AssetName).sendKeys(value);
        
        return this;
    }
    public FinderAssetPage clickFinderAsset(){
        driver.findElement(FinderAsset).click();
        return this;
    }
    
    
}