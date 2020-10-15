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

public class DocumentosPage {
    private By ClickDocumentos = By.xpath("//*[@id='header-documents']/span");
    private By ClickDocumentos1 = By.xpath("//*[@id='header-documents']/span");
    private By ClickDocumentos2 = By.xpath("//*[@id='header-documents']/span");
    private By ClickDocumentos3 = By.xpath("//*[@id='header-documents']/span");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public DocumentosPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public DocumentosPage clickClickDocumentos(){
        driver.findElement(ClickDocumentos).click();
        return this;
    }
    public DocumentosPage clickClickDocumentos1(){
        driver.findElement(ClickDocumentos1).click();
        return this;
    }
    public DocumentosPage clickClickDocumentos2(){
        driver.findElement(ClickDocumentos2).click();
        return this;
    }
    public DocumentosPage clickClickDocumentos3(){
        driver.findElement(ClickDocumentos3).click();
        return this;
    }
    
    
}