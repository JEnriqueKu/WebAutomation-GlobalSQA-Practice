package pages;

import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class HomePage3 extends BasePage {
    public HomePage3(WebDriver driver) {
        super(driver);
    }

    public void closeCurrentPage(){
        closePage();
    }
}
