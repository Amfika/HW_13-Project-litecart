package page_object.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import page_object.PageBase;

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
        getDriver();
    }

    public void goToRuberDucksPage(){
        getDriver().findElement(ruberDucksMenu).click();
    }

    public String findHeader(){
        String textHeader = getDriver().findElement(By.xpath("//*[@id='box-category']/*[@class='title']")).getText();
        return textHeader;
    }

    public void selectDuck(){
        getDriver().findElement(yellowDuckTitle).click();
    }

    public void selectSizeDuckAndAddCart() throws InterruptedException {
        Select select = new Select(getDriver().findElement(dropDown));
        select.selectByValue("Large");
        getDriver().findElement(addCartButton).click();
    }

    public void goToCart() throws InterruptedException {
        Thread.sleep(5000);
        getDriver().findElement(cart).click();
    }

    public void byDuck() throws InterruptedException {
        getDriver().findElement(firstName).sendKeys("aa");
        getDriver().findElement(lastName).sendKeys("aa");
        getDriver().findElement(address).sendKeys("aa");
        getDriver().findElement(postcode).sendKeys("220121");
        getDriver().findElement(city).sendKeys("Minsk");
        getDriver().findElement(emailInput).sendKeys("asanastasia1@gmail.com");
        getDriver().findElement(phone).sendKeys("+375291111111");
        getDriver().findElement(setAddressButton).click();
        Thread.sleep(5000);
        getDriver().findElement(confirmButton).click();
    }

    public String orderMessage(){
        String orderMess = getDriver().findElement(boxOrder).getText();
        return orderMess;
    }
}
