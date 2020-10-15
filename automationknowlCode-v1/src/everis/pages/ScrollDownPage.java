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

public class ScrollDownPage {
    private By ScrollDownPage = By.xpath("//*[@id='0']/div/div[3]/skmo-cloud-tags/ul/li[1]/a");
    
    
    private WebDriver driver;
    private JavascriptExecutor js;
    
    public ScrollDownPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor)driver;
    }

    public ScrollDownPage clickScrollDownPage(){
        {
                boolean found = false;
                long end = System.currentTimeMillis() + 5000;
                while (!found) {
                    try{
                        Utils.isElementEnabled(driver.findElement(ScrollDownPage), driver);
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