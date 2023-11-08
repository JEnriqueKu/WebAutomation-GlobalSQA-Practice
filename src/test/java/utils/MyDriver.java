package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

    WebDriver driver;

    public MyDriver(String browser) {
        if (browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
        else if (browser.equalsIgnoreCase("edge")) driver = new EdgeDriver();
        else driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
