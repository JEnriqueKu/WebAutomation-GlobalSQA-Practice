package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class MyDriver {

    WebDriver driver;

    public MyDriver(String browser) {
        if (browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
        else if (browser.equalsIgnoreCase("edge")) driver = new EdgeDriver();
        else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addExtensions(new File("src/test/resources/GIGHMMPIOBKLFEPJOCNAMGKKBIGLIDOM_5_13_0_0.crx"));
            driver = new ChromeDriver(chromeOptions);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
