package tests.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.TestSelenideConfigLogger.logSelenideMainConfigValues;

public class DummyMainWebConfTest extends TestBaseWebMain {


    @Test
    @Tag("dry")
    void emptyTest() {

        System.out.println("Just an empty test \n");
        logSelenideMainConfigValues();
        Assertions.assertTrue(true);

    }

}
