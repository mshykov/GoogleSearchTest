package net.itlabs;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by Shykov M on 20.05.2015
 */
public class GoogleSearchTest {

    @Test
    public void searchText() {
        open("http://www.google.com/ncr");
        $(By.name("q")).setValue("selenium").pressEnter();
        $$(".srg>li").get(8).shouldHave(Condition.text("A browser automation framework and ecosystem"));
    }
}
