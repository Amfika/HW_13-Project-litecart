package каталог;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;

public class CatalogTest {

    @Test(description = "Переход в каталог")
    public static void goToCatalog(){
        String searchText = "Rubber Ducks";

        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//nav[@id='site-menu']//li[@class='category-1']/*")).click();
        WebElement element = driver.findElement(By.xpath("//*[@id='box-category']/*[@class='title']"));

        Assert.assertEquals(element.getText(), searchText);

        driver.quit();
    }

    @Test(description = "Покупка утки")
    public static void selectDuck() throws InterruptedException {
        String resultAfterSale = "Your order is successfully completed!";

        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");
        driver.findElement(By.xpath("//nav[@id='site-menu']//li[@class='category-1']/*")).click();
        driver.findElement(By.cssSelector("a[title='Yellow Duck']")).click();

        Select select = new Select(driver.findElement(By.name("options[Size]")));
        select.selectByValue("Large");

        driver.findElement(By.xpath("//td[@class='quantity']//button[@name='add_cart_product']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='cart']/a[@class='content']")).click();

        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("dd");
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("dd");
        driver.findElement(By.cssSelector("[name='address1']")).sendKeys("dd");
        driver.findElement(By.cssSelector("[name='postcode']")).sendKeys("220121");
        driver.findElement(By.cssSelector("[name='city']")).sendKeys("Minsk");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("asanastasia1@gmail.com");
        driver.findElement(By.cssSelector("[name='phone']")).sendKeys("+375291111111");
        driver.findElement(By.xpath("//div[@class='billing-address']//button[@name='set_addresses']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("button[name='confirm_order']")).click();

        WebElement sale = driver.findElement(By.xpath("//div[@id='box-order-success']/*"));

        Assert.assertEquals(sale.getText(), resultAfterSale);

        driver.quit();
    }
}
