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

public class ClickFirstEmailPage {
    private By ClickEmail = By.xpath("//*[@id='0']/ul/li[1]/div[2]/div/a");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public ClickFirstEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public ClickFirstEmailPage clickClickEmail(){
        driver.findElement(ClickEmail).click();
        return this;
    }
    
    
}