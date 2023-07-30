package page_object.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import page_object.PageBase;

import static com.codeborne.selenide.Selenide.$;
import static page_object.WebDriverContainer.getDriver;

public class CatalogPage extends PageBase {
    private By emailInput = By.name("email");
    private By ruberDucksMenu = By.xpath("//nav[@id='site-menu']//li[@class='category-1']/*");
    private By firstName = By.name("firstname");
    private By lastName = By.name("lastname");
    private By address = By.name("address1");
    private By postcode = By.name("postcode");
    private By city = By.name("city");
    private By phone = By.name("phone");
    private By setAddressButton = By.xpath("//div[@class='billing-address']//button[@name='set_addresses']");
    private By confirmButton = By.cssSelector("button[name='confirm_order']");
    private By boxOrder = By.xpath("//div[@id='box-order-success']/*");
    private By yellowDuckTitle = By.cssSelector("a[title='Yellow Duck']");
    private By dropDown = By.name("options[Size]");
    private By addCartButton = By.xpath("//td[@class='quantity']//button[@name='add_cart_product']");
    private By cart = By.xpath("//div[@id='cart']/a[@class='content']");

    public CatalogPage(){
    }

    public void goToRuberDucksPage(){
        $(ruberDucksMenu).click();
    }

    public String findHeader(){
        String textHeader = $(By.xpath("//*[@id='box-category']/*[@class='title']")).getText();
        return textHeader;
    }

    public void selectDuck(){
        $(yellowDuckTitle).click();
    }

    public void selectSizeDuckAndAddCart() throws InterruptedException {
        Select select = new Select($(dropDown));
        select.selectByValue("Large");
        $(addCartButton).click();
    }

    public void goToCart() throws InterruptedException {
        Thread.sleep(5000);
        $(cart).click();
    }

    public void byDuck() throws InterruptedException {
        $(firstName).sendKeys("aa");
        $(lastName).sendKeys("aa");
        $(address).sendKeys("aa");
        $(postcode).sendKeys("220121");
        $(city).sendKeys("Minsk");
        $(emailInput).sendKeys("asanastasia1@gmail.com");
        $(phone).sendKeys("+375291111111");
        $(setAddressButton).click();
        Thread.sleep(5000);
        $(confirmButton).click();
    }

    public String orderMessage(){
        String orderMess = $(boxOrder).getText();
        return orderMess;
    }
}
