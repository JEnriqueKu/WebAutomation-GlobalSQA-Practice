package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.Set;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Open New Tab")
    WebElement openNewTab;
    @FindBy(css = "div.resp-tab-content.resp-tab-content-active a.button_hilite")
    WebElement clickHere;

    public void clickOnOpenNewTab(){
        waitForElementToBeClickable(openNewTab);
    }
    public HomePage2 clickOnClickHere(){
        waitForElementToBeClickable(clickHere);
        return new HomePage2(super.getDriver());
    }

    public void switchToPage2(){
        Set<String> handles = getCurrentWindowHandles();
        for (String handle : handles) {
            System.out.println(handle);
        }
        getDriver().switchTo().window(handles.toArray()[1].toString());
    }

    public void switchToPage1(){
        String currentPageHandle = getDriver().getWindowHandle();
        System.out.println(currentPageHandle);
        getDriver().switchTo().window(currentPageHandle);
    }

    public void closeAdAlert(){
        closeAlert();
    }

    public AlertsPage navigateToAlerts(){
        navigateTo("https://demo.automationtesting.in/Alerts.html");
        return new AlertsPage(getDriver());
    }
}
