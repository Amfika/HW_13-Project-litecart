package корзина;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest {

    @Test(description = "Открытие корзины")
    public static void openCart() {
        String emptyCartText = "There are no items in your cart.";

        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("a[href='https://litecart.stqa.ru/en/checkout']"));
        driver.findElement(By.xpath("//div[@id='cart']//a[@href='https://litecart.stqa.ru/en/checkout'][@class='link']")).click();

        WebElement text = driver.findElement(By.xpath("//div[@id='checkout-cart-wrapper']/*/*"));

        Assert.assertEquals(text.getText(), emptyCartText);

        driver.quit();
    }

    @Test(description = "Возврат из корзины")
    public static void exitFromCart() {
        String mainPage = "https://litecart.stqa.ru/images/slides/1-lonely-duck.jpg";

        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("a[href='https://litecart.stqa.ru/en/checkout']"));
        driver.findElement(By.xpath("//div[@id='cart']//a[@href='https://litecart.stqa.ru/en/checkout'][@class='link']")).click();
        driver.findElement(By.xpath("//div[@id='checkout-cart-wrapper']//a[@href='https://litecart.stqa.ru/en/']")).click();
        WebElement mainPagePicture = driver.findElement(By.xpath("//li[@id='rslides1_s0']/*/*"));

        Assert.assertEquals(mainPagePicture.getAttribute("src"), mainPage);

        driver.quit();
    }

    @Test(description = "отображение добавленных элементов в корзине")
    public static void checkCart() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.cssSelector("a[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/red-duck-p-3']")).click();
        driver.findElement(By.xpath("//td[@class='quantity']//button[@name='add_cart_product']")).click();
        String codeElementFromCatalog = driver.findElement(By.xpath("//div[@class='codes']/*")).getText();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='cart']/a[@class='content']")).click();
        String codeFromCart = driver.findElement(By.cssSelector("span[style='color: #999; font-size: 10px;']")).getText();

        Assert.assertTrue(codeFromCart.contains(codeElementFromCatalog));

        driver.quit();
    }
}

