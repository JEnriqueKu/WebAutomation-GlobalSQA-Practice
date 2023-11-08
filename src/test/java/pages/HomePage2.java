package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;

public class HomePage2 extends BasePage {
    public HomePage2(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "iFrame")
    WebElement iframeButton;
    @FindBy(id = "portfolio_filter")
    WebElement trainings;
    @FindBy(css = "div[data-option-value='.softwaretesting']")
    WebElement softwareTestingButton;
    @FindBy(css = "a[href='https://www.globalsqa.com/training/manual-testing-training/']")
    WebElement manualTesting;
    @FindBy(css = "#jp-relatedposts")
    WebElement relatedPosts;
    @FindBy(id = "Course Content")
    WebElement courseContent;
    @FindBy(className = "page_heading")
    WebElement pageHeading;
    @FindAll(@FindBy(css = "div.sixteen.columns h3 strong"))
    List<WebElement> subHeaders;
    @FindBy(id = "menu-item-2816")
    WebElement alerBox;


    public void clickOnIFrame(){
        waitForElementToBeClickable(iframeButton);
    }

    public void enterIFrame(){
        switchToIFrameByName("globalSqa");
    }

    public void exitIFrame(){
        switchToParentFrame();
    }

    public void clickOnTrainingButton(){
        waitForElementToBeClickable(trainings);
    }
    public void clickOnSoftwarwTestingButton(){
        waitForElementToBeClickable(softwareTestingButton);
    }

    public void clickOnManualTesting() {
        waitForElementToBeVisible(manualTesting);
        waitForElementToBeClickable(manualTesting);
    }

    public String courseContent(){
        waitForElementToBeVisible(courseContent);
        return courseContent.getText();
    }
    public String subHeader1(){
        waitForElementToBeVisible(subHeaders.get(0));
        return subHeaders.get(0).getText();
    }

    public String subHeader2(){
        waitForElementToBeVisible(subHeaders.get(1));
        return subHeaders.get(1).getText();
    }

    public String pageHeadingText(){
        waitForElementToBeVisible(pageHeading);
        return pageHeading.getText();
    }

    public HomePage3 clickOnAlertBox(){
        waitForElementToBeClickable(alerBox);
        return new HomePage3(getDriver());
    }

}
