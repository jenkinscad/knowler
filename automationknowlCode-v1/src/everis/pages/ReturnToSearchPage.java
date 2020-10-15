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

public class ReturnToSearchPage {
    private By ReturnToSearch = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/skmo-back-button/div/a/span");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public ReturnToSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public ReturnToSearchPage clickReturnToSearch(){
        driver.findElement(ReturnToSearch).click();
        return this;
    }
    
    
}