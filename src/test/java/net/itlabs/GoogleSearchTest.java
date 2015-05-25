package net.itlabs;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

/**
 * Created by Shykov M on 20.05.2015
 */
public class GoogleSearchTest {

    @Test
    public void searchTextUsingSelenium() {
        WebDriver driver = new FirefoxDriver();
        WebElement myElement;
        driver.get("http://www.google.com/ncr");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.name("q")).sendKeys("selenium" + Keys.ENTER);
        myElement = driver.findElements(By.cssSelector(".srg>li")).get(7);
        assertTrue(myElement.getText().contains("A browser automation framework and ecosystem"));
        //(new WebDriverWait(driver, 4)).until(textToBePresentInElementLocated(
        //        By.cssSelector("#ires li.g:nth-child(7)"),
        //        "A browser automation framework"));
        driver.close();
    }

    @Test
    public void searchTextUsingSelenide() {
        open("http://www.google.com/ncr");
        $(By.name("q")).setValue("selenium").pressEnter();
        $$(".srg>li").get(7).shouldHave(Condition.text("A browser automation framework and ecosystem"));
    }

}
