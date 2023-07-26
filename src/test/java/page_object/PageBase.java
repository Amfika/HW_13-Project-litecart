package page_object;

import org.openqa.selenium.WebDriver;

public class PageBase {
    WebDriver driver;

    protected static String title;

    public boolean hasLoaded(WebDriver driver){
        return driver.getTitle().equals(title);
    }
}
