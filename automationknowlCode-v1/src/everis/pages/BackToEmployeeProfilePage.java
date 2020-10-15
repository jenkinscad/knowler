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

public class BackToEmployeeProfilePage {
    private By BackToEmployeeProfile = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/skmo-back-button/div/a/span/span");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public BackToEmployeeProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public BackToEmployeeProfilePage clickBackToEmployeeProfile(){
        driver.findElement(BackToEmployeeProfile).click();
        return this;
    }
    
    
}