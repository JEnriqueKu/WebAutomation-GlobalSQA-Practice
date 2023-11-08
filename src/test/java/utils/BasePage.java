package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Set;

public class BasePage {

    private WebDriver driver;
    private Wait<WebDriver> wait;
    private Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                        .pollingEvery(Duration.ofMillis(500))
                                .ignoring(NoSuchElementException.class);

        this.actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollDownPage(){
        actions.scrollByAmount(0,200).perform();
    }

    public void switchToIFrameByName(String iFrameId){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(iFrameId)));
        driver.switchTo().frame(iFrameId);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public Set<String> getCurrentWindowHandles(){
        return getDriver().getWindowHandles();
    }

    public void closeCurrentPage(){
        driver.close();
    }

}
