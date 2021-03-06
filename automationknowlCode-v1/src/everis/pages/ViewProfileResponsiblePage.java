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

public class ViewProfileResponsiblePage {
    private By ViewProfileResponsible = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/div[1]/div[2]/div[2]/a");
    private By ViewProfileResponsible1 = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/div[1]/div[2]/div[2]/a");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public ViewProfileResponsiblePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public ViewProfileResponsiblePage clickViewProfileResponsible(){
        driver.findElement(ViewProfileResponsible).click();
        return this;
    }
    public ViewProfileResponsiblePage clickViewProfileResponsible1(){
        driver.findElement(ViewProfileResponsible1).click();
        return this;
    }
    
    
}