package tests.web;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class BellIntTests extends TestBaseWebMain {

    @AfterAll
    public static void closeDriver() {
        closeWebDriver();
    }

    @Test
    @Tag("simple_sampler")
    @Tag("bell")
    void bellTrainingTest() {

        open("https://bellintegrator.ru/?route=information/training");

        $("h1").shouldHave(Condition.text("Обучение для начинающих специалистов"));

    }

    @ParameterizedTest
    @Tag("simple_sampler")
    @Tag("bell")
    @ValueSource(strings = {"акция", "новая", "услуг", "проверки", "условия"})
    void bellSearchTest(String value) {

        open("https://bellintegrator.ru/");
        $("#search-open").shouldBe(Condition.interactable);
        $("#search-open").click();

        $("input[name=search]").sendKeys(value);
        $("input[name=search]").pressEnter();

        $$("h2").first().shouldHave(Condition.text("Поиск - " + value));
        $$("h2").get(1).shouldHave(Condition.text("Результаты поиска"));

        int warnings = $$x("//b[contains(text(),'Warning')]").size();
        Assertions.assertEquals(0, warnings, "Не должно быть PHP warnings");

    }



}
