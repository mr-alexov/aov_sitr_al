package tests.web;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Magento2DemoMagebitTests {


    @Test
    @Tag("simple_sampler")
    void myBasicMagento2DemoLoginTest() {

        Configuration.holdBrowserOpen = true;

        open("https://magento2-demo.magebit.com/");
        $("li.authorization-link").click();
        $("#email").setValue("tac_books_240424al@mailnesia.com");
        $("#pass").setValue("tbtbTBTB248");
        $("button.login").click();

    }

    @AfterAll
    public static void closeDriver() {
        closeWebDriver();
    }

}
