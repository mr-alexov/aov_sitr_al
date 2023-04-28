package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.HardcodedWebConfigRunner;
import config.OwnerWebConfigRunner;
import helpers.Attach;
import helpers.TestLoggerHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static helpers.TestLoggerHelper.logAndPassSystemProperty;


public class TestBaseWebMain {

    @BeforeAll
    static void setUp() {
        // Простое добавление лисенера для аллюр отчета
        SelenideLogger.addListener("allure", new AllureSelenide());

        new OwnerWebConfigRunner().runWebConfig();

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
