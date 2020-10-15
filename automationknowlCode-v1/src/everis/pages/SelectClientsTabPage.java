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

public class SelectClientsTabPage {
    private By SelectClientsTab = By.xpath("//*[@id='header-customeraccounts']");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public SelectClientsTabPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public SelectClientsTabPage clickSelectClientsTab(){
        driver.findElement(SelectClientsTab).click();
        return this;
    }
    
    
}