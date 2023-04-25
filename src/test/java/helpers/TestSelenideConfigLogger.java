package helpers;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSelenideConfigLogger {

    Logger logger =  LoggerFactory.getLogger(TestSelenideConfigLogger.class);

    public static TestSelenideConfigLogger getTestSelenideConfigLogger(){
        return new TestSelenideConfigLogger();
    }

    public void logBrowserName(){
        logger.info("Selenide browser name: " + Configuration.browser);
    }

    public void logBrowserSize(){
        logger.info("Selenide browser size: " + Configuration.browserSize);
    }

    public void logBrowserVersion(){
        logger.info("Selenide browser version: " + Configuration.browserVersion);
    }

    public void logBrowserBaseUrl(){
        logger.info("Selenide base URL: " + Configuration.baseUrl);
    }

    public void logBrowserRemote(){
        logger.info("Selenide remote: " + Configuration.remote);
    }

}
