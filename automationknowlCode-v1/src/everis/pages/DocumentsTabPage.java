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

public class DocumentsTabPage {
    private By DocumentsTab = By.xpath("//*[@id='header-documents']/span");
    private By DocumentsTab1 = By.xpath("//*[@id='header-documents']/span");
    private By DocumentsTab2 = By.xpath("//*[@id='header-documents']/span");
    private By DocumentsTab3 = By.xpath("//*[@id='header-documents']/span");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public DocumentsTabPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public DocumentsTabPage clickDocumentsTab(){
        driver.findElement(DocumentsTab).click();
        return this;
    }
    public DocumentsTabPage clickDocumentsTab1(){
        driver.findElement(DocumentsTab1).click();
        return this;
    }
    public DocumentsTabPage clickDocumentsTab2(){
        driver.findElement(DocumentsTab2).click();
        return this;
    }
    public DocumentsTabPage clickDocumentsTab3(){
        driver.findElement(DocumentsTab3).click();
        return this;
    }
    
    
}