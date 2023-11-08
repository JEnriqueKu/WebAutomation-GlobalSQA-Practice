package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#OKTab .btn")
    private WebElement alertWithOkButton;

    public void clickOnAlertWithOkButton(){
        waitForElementToBeClickable(alertWithOkButton);
    }

    public void acceptAlert(){
        clickOnAlertButton();
    }
}
