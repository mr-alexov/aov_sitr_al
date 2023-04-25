package tests.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.TestBaseWeb;

public class DummyEmptyWebConfTest extends TestBaseWeb {


    @Tag("dry")
    @Test
    void emptyTest() {

        System.out.println("Just an empty test \n");
        Assertions.assertTrue(true);

    }

}
