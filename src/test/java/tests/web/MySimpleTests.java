package tests.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MySimpleTests extends TestBaseWebMain {

    // Очень простые тесты, которые "почти ничего не делают"

    @Tag("simple_sampler")
    @Tag("simple_web")
    @Test
    void dummyDuckDuckGoSearch() {
        open("https://duckduckgo.com/");
        $("[id=search_form_input_homepage]").setValue("selenide").pressEnter();

        SelenideElement links = $("ol.react-results--main");
        links.shouldHave(text("https://selenide.org"));

    }

    @Tag("simple_sampler")
    @Tag("simple_web")
    @Test
    void theInternetHerokuTest() {

        open("https://the-internet.herokuapp.com/login");

        $("#username").shouldBe(Condition.interactable, Duration.ofSeconds(20));
        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $("button.radius").click();

        $("div.flash").shouldHave(text("You logged into a secure area!"));

    }

}
