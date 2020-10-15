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

public class SelectProjectsTabPage {
    private By SelectProjectsTab = By.xpath("//*[@id='header-projects']");
    private By SelectProjectsTab1 = By.xpath("//*[@id='header-projects']/span");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public SelectProjectsTabPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public SelectProjectsTabPage clickSelectProjectsTab(){
        driver.findElement(SelectProjectsTab).click();
        return this;
    }
    public SelectProjectsTabPage clickSelectProjectsTab1(){
        driver.findElement(SelectProjectsTab1).click();
        return this;
    }
    
    
}