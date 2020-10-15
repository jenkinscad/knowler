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

public class ViewProfileColleaguePage {
    private By ViewProfileColleague = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/p-scrollpanel/div/div[1]/div/div/div/div[1]/div[3]/a");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public ViewProfileColleaguePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public ViewProfileColleaguePage clickViewProfileColleague(){
        driver.findElement(ViewProfileColleague).click();
        return this;
    }
    
    
}