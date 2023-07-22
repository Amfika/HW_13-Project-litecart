package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverContainer {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            initDriver();
        }
        return driver;
    }

    public static void initDriver(){
        Browser browser = Browser.getEnumByLabel(System.getProperty("browser", Browser.CHROME.getBrowserName()));

        switch (browser){
            case CHROME:driver = new ChromeDriver();
            case EDGE:driver = new EdgeDriver();
        }
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}
