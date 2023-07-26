package htmlelements.pages;

import htmlelements.blocks.HeaderMenuBlock;
import htmlelements.blocks.LoginBlock;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class MainPage {
    public LoginBlock loginBlock;

    public HeaderMenuBlock headerMenuBlock;

    public MainPage(WebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
    }
}
