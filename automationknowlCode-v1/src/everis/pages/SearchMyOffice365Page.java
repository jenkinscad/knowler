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

public class SearchMyOffice365Page {
    private By SearchMyOffice365 = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/div/div[2]/div[2]");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public SearchMyOffice365Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public SearchMyOffice365Page clickSearchMyOffice365(){
        driver.findElement(SearchMyOffice365).click();
        return this;
    }
    
    
}