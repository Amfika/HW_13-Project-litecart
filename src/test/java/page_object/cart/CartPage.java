package page_object.cart;

import org.openqa.selenium.By;
import page_object.PageBase;

import static page_object.WebDriverContainer.getDriver;

public class CartPage extends PageBase {
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
    private By textFromEmptyCart = By.xpath("//div[@id='checkout-cart-wrapper']/*/*");
    private By backButton = By.xpath("//div[@id='checkout-cart-wrapper']//a[@href='https://litecart.stqa.ru/en/']");
    private By mainPagePicture = By.xpath("//li[@id='rslides1_s0']/*/*");
    private By redDuck = By.cssSelector("a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/red-duck-p-3']");
    private By redDuckName = By.xpath("//div[@id='box-product']/*/*");
    private By redDuckNameFromCart = By.xpath("//div[@style='display: inline-block;']//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/red-duck-p-3']/*");

    public CartPage(){
        getDriver();
    }

    public void openCart(){
        getDriver().findElement(cart).click();
    }

    public String emptyCartGetMess(){
        String message = getDriver().findElement(textFromEmptyCart).getText();
        return message;
    }

    public void clickBackButton(){
        getDriver().findElement(backButton).click();
    }

    public String findMainPagePicture(){
        String picture = getDriver().findElement(mainPagePicture).getAttribute("src");
        return picture;
    }

    public void chooseDuck(){
        getDriver().findElement(redDuck).click();
        getDriver().findElement(addCartButton).click();
    }

    public String getDuckName(){
        String mess = getDriver().findElement(redDuckName).getText();
        return mess;
    }
    public String getDuckNameFromCart(){
        String mess2 = getDriver().findElement(redDuckNameFromCart).getText();
        return mess2;
    }
}
