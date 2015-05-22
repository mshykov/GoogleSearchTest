package net.itlabs;

import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Shykov M on 20.05.2015
 */
public class GoogleSearchTest {

    @Test
    public void searchText() {
        open("http://www.google.com/ncr");
        $("[name='q']").setValue("selenium").pressEnter();
        $$(".srg>li").get(8).shouldHave(Condition.text("A browser automation framework and ecosystem"));
    }
}
