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

public class SelectDocumentsTabPage {
    private By SelectDocumentsTab = By.xpath("//*[@id='header-documentsMs']/span");
    private By SelectDocumentsTab1 = By.xpath("//*[@id='header-documents']/span");
    private By SelectDocumentsTab2 = By.xpath("//*[@id='header-documents']/span");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public SelectDocumentsTabPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public SelectDocumentsTabPage clickSelectDocumentsTab(){
        driver.findElement(SelectDocumentsTab).click();
        return this;
    }
    public SelectDocumentsTabPage clickSelectDocumentsTab1(){
        driver.findElement(SelectDocumentsTab1).click();
        return this;
    }
    public SelectDocumentsTabPage clickSelectDocumentsTab2(){
        driver.findElement(SelectDocumentsTab2).click();
        return this;
    }
    
    
}