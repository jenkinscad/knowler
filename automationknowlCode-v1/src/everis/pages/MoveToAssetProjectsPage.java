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

public class MoveToAssetProjectsPage {
    private By MoveToAssetProjects = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[12]/div/ng-component/div/ng-component/div");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public MoveToAssetProjectsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public MoveToAssetProjectsPage clickMoveToAssetProjects(){
        {
                boolean found = false;
                long end = System.currentTimeMillis() + 5000;
                while (!found) {
                    try{
                        Utils.isElementEnabled(driver.findElement(MoveToAssetProjects), driver);
                        found = true;
                    } catch (Exception e) {
                        if (System.currentTimeMillis() > end) {
                            throw e;
                        }
                        js.executeScript("window.scrollBy(0,100)");
                    }
                }
            }
            
        return this;
    }
    
    
}