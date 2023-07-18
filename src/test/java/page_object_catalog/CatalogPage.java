package page_object_catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CatalogPage {
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
    WebDriver driver;

    public CatalogPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToRuberDucksPage(){
        driver.findElement(ruberDucksMenu).click();
    }

    public String findHeader(){
        String textHeader = driver.findElement(By.xpath("//*[@id='box-category']/*[@class='title']")).getText();
        return textHeader;
    }

    public void selectDuck(){
        driver.findElement(yellowDuckTitle).click();
    }

    public void selectSizeDuckAndAddCart() throws InterruptedException {
        Select select = new Select(driver.findElement(dropDown));
        select.selectByValue("Large");
        driver.findElement(addCartButton).click();
    }

    public void goToCart() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(cart).click();
    }

    public void byDuck() throws InterruptedException {
        driver.findElement(firstName).sendKeys("aa");
        driver.findElement(lastName).sendKeys("aa");
        driver.findElement(address).sendKeys("aa");
        driver.findElement(postcode).sendKeys("220121");
        driver.findElement(city).sendKeys("Minsk");
        driver.findElement(emailInput).sendKeys("asanastasia1@gmail.com");
        driver.findElement(phone).sendKeys("+375291111111");
        driver.findElement(setAddressButton).click();
        Thread.sleep(5000);
        driver.findElement(confirmButton).click();
    }

    public String orderMessage(){
        String orderMess = driver.findElement(boxOrder).getText();
        return orderMess;
    }
}
