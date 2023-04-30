package tests.web;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class ChayInfoTests extends TestBaseWebMain {


    @Test
    @Tag("simple_sampler")
    void myBasicLoginTest() {

        open("https://www.chay.info/");
        $("[data-id='sign-in']").click();
        $("input[type=email]").setValue("tac_books_240424al@mailnesia.com");
        $("input[type=password]").setValue("tbtbTBTB248");
        $x("//button[contains(text(),'Войти')]").click();

    }

    @AfterAll
    public static void closeDriver() {
        closeWebDriver();
    }

}
