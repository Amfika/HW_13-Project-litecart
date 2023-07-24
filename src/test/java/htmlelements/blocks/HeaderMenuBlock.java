package htmlelements.blocks;

import jdk.jfr.Name;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("Header Menu")
@FindBy(id = "site-menu")
public class HeaderMenuBlock extends HtmlElement {

    @Name("Rubber ducks menu item")
    @FindBy(css = "#site-menu [href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']")
    private WebElement rubberDucksMenuItem;

    public void goRubberDucksPage() {
        rubberDucksMenuItem.click();
    }
}
