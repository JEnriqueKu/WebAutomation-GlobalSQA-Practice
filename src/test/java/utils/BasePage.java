package utils;

import org.openqa.selenium.*;
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
                .withTimeout(Duration.ofSeconds(8))
                        .pollingEvery(Duration.ofMillis(500))
                                .ignoring(NoSuchElementException.class);

        this.actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected void navigateTo(String url){
        driver.get(url);
    }

    protected void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeInvisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void scrollDown(){
        actions.scrollByAmount(0,200).perform();
    }

    protected void switchToIFrameByName(String iFrameId){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(iFrameId)));
            driver.switchTo().frame(iFrameId);

    }

    protected void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    protected void clickCancelOnAlertButton(){
        driver.switchTo().alert().dismiss();
    }

    protected Set<String> getCurrentWindowHandles(){
        return getDriver().getWindowHandles();
    }

    protected void closePage(){
        driver.close();
    }

}
