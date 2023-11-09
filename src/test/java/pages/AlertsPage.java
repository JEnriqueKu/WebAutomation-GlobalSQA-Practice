package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#CancelTab .btn")
    private WebElement displayConfirmBoxButton;

    @FindBy(css = ".nav.nav-tabs.nav-stacked [href='#CancelTab']")
    private WebElement alertWithOkAndCancelButton;
    @FindBy(id = "demo")
    private WebElement confirmText;

    public void clickOnAlertWithOkAndCancelButton(){
        waitForElementToBeClickable(alertWithOkAndCancelButton);
    }

    public void clickOnDisplayConfirmButton(){
        waitForElementToBeClickable(displayConfirmBoxButton);
    }

    public void cancelAlert(){
        clickCancelOnAlertButton();
    }

    public String getConfirmText(){
        return confirmText.getText();
    }
}
