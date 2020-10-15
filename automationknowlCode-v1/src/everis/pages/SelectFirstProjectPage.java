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

public class SelectFirstProjectPage {
    private By SelectFirstProject = By.xpath("//*[@id='projects']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public SelectFirstProjectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public SelectFirstProjectPage clickSelectFirstProject(){
        driver.findElement(SelectFirstProject).click();
        return this;
    }
    
    
}