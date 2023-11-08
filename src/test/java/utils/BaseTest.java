package utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;

public class BaseTest {
    MyDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser","url"})
    public void beforeMethod(String browser, String url){
        driver = new MyDriver(browser);
        driver.getDriver().get(url);
        driver.getDriver().manage().window().maximize();
    }

    public HomePage loadFirstPage(){
        return new HomePage(driver.getDriver());
    }

    @AfterMethod
    public void afterMethod(){
       // driver.getDriver().quit();
    }
}
