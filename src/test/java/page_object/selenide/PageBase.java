package page_object.selenide;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class PageBase {

    protected static String title;

    public boolean hasLoaded(){
        //return driver.getTitle().equals(title);
        return $(By.className(title)).equals(title);
    }
}
