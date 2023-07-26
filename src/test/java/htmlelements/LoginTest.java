package htmlelements;

import htmlelements.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public static void loginTest(){
        WebDriver driver = new ChromeDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.loginBlock.attemptLogin("","");
        mainPage.headerMenuBlock.goRubberDucksPage();
    }

}
