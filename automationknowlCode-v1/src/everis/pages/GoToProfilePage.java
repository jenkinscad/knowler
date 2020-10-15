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

public class GoToProfilePage {
    private By ClickColleagueProfile = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/p-scrollpanel/div/div[1]/div/div/div/div[1]/div[3]/a");
    private By ClickGoToProfile = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By ClickGoToProfile1 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By ClickGoToProfile2 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By ClickGoToProfile3 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By GoToProfile = By.xpath("//*[@id='employees']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By GoToProfile1 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By GoToProfile2 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By GoToProfile3 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By GoToProfile4 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By GoToProfile5 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By GoToProfile6 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By GoToProfile7 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[5]/div/ng-component/div/ng-component/a");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public GoToProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public GoToProfilePage clickClickColleagueProfile(){
        driver.findElement(ClickColleagueProfile).click();
        return this;
    }
    public GoToProfilePage clickClickGoToProfile(){
        driver.findElement(ClickGoToProfile).click();
        return this;
    }
    public GoToProfilePage clickClickGoToProfile1(){
        driver.findElement(ClickGoToProfile1).click();
        return this;
    }
    public GoToProfilePage clickClickGoToProfile2(){
        driver.findElement(ClickGoToProfile2).click();
        return this;
    }
    public GoToProfilePage clickClickGoToProfile3(){
        driver.findElement(ClickGoToProfile3).click();
        return this;
    }
    public GoToProfilePage clickGoToProfile(){
        driver.findElement(GoToProfile).click();
        return this;
    }
    public GoToProfilePage clickGoToProfile1(){
        driver.findElement(GoToProfile1).click();
        return this;
    }
    public GoToProfilePage clickGoToProfile2(){
        driver.findElement(GoToProfile2).click();
        return this;
    }
    public GoToProfilePage clickGoToProfile3(){
        driver.findElement(GoToProfile3).click();
        return this;
    }
    public GoToProfilePage clickGoToProfile4(){
        driver.findElement(GoToProfile4).click();
        return this;
    }
    public GoToProfilePage clickGoToProfile5(){
        driver.findElement(GoToProfile5).click();
        return this;
    }
    public GoToProfilePage clickGoToProfile6(){
        driver.findElement(GoToProfile6).click();
        return this;
    }
    public GoToProfilePage clickGoToProfile7(){
        driver.findElement(GoToProfile7).click();
        return this;
    }
    
    
}