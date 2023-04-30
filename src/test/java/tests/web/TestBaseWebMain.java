package tests.web;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.OwnerWebConfigRunner;
import helpers.Attach;
import helpers.TestLoggerHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static helpers.TestSelenideConfigLogger.logSelenideMainConfigValues;


public class TestBaseWebMain {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new OwnerWebConfigRunner().runWebConfig();
        logSelenideMainConfigValues();
    }

    @AfterEach
    void addAttachments() {
        Attach.attachAsText("My custom log", TestLoggerHelper.getCustomLogs());

        // TODO: Доделать чтобы не сыпалось исключений с dryRun независимо от вариантов запуска.

        if (!"yes".equals(System.getProperty("dryRun"))) {
            Attach.screenshotAs("Last screen");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
    }

}
