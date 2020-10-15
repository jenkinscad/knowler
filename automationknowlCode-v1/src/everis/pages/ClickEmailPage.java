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

public class ClickEmailPage {
    private By ClickEmail1 = By.xpath("//*[@id='mails']/div/div/div/div[1]/skmo-entityretrieval-results/div/skmo-element-type-myoffice[1]/div/div/div[1]/div[2]/a");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public ClickEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public ClickEmailPage clickClickEmail1(){
        driver.findElement(ClickEmail1).click();
        return this;
    }
    
    
}