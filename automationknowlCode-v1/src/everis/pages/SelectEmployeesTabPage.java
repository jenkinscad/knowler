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

public class SelectEmployeesTabPage {
    private By SelectEmployeesTab1 = By.xpath("//*[@id='header-employees']/span");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public SelectEmployeesTabPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public SelectEmployeesTabPage clickSelectEmployeesTab1(){
        driver.findElement(SelectEmployeesTab1).click();
        return this;
    }
    
    
}