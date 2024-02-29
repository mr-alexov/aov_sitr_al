package tests.web.probes;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Disabled("May not work via VPN")
public class LanitTests {

    @Test
    void lanitTest01() {
        open("https://www.lanit.ru/");

        String searchText = "команда";

        $(".search_header").click();
        $(".search__input").setValue(searchText).pressEnter();
        $(".search__item").shouldHave(Condition.text(searchText));
    }
}
