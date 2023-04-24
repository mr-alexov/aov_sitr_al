package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import helpers.TestLoggerHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static helpers.TestLoggerHelper.logAndPassSystemProperty;


public class TestBaseWeb {

    @BeforeAll
    static void setUp() {
        // Простое добавление лисенера для аллюр отчета
        SelenideLogger.addListener("allure", new AllureSelenide());

        // Улучшает загрузку страниц если какой-то ресурс проблемно тянется
        Configuration.pageLoadStrategy = "eager";

        // Configuration.holdBrowserOpen = true;



        // Пример обработки параметров
        // TODO: Перенести параметры в owner конфиг

        Configuration.browserSize = logAndPassSystemProperty("browserSize", "1920x1080");

        Configuration.remote = logAndPassSystemProperty("remoteURL", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        // Конфигурация без указания в джобе:
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        TestLoggerHelper.logToLoggerAndToCustomLog("Set configuration.browserCapabilities: " + Configuration.browserCapabilities + "\n");

    }

    @AfterEach
    void addAttachments() {
        Attach.attachAsText("My custom log", TestLoggerHelper.getCustomLogs());

        // Проверка на специальную задачу dryRun -- которая для скорости не будет гонять никаких тестов
        // TODO: Проверить можно ли это убрать с новой обработкой исключений которая будет гасить проблемы аллюр отчета

        if (!"yes".equals(System.getProperty("dryRun"))) {
            Attach.screenshotAs("Last screen");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
    }

}
