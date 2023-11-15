package tests.misk;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static snippets.FakerTests.getRandom;
import static org.assertj.core.api.Assertions.*;

public class FakerTests {


    @Disabled
    @Test
    void fakerOptionTest() {

        Set<String> results = new HashSet<>();

        for (int i = 0; i < 50; i++) {
            results.add(getRandom());
        }

        assertThat(results).containsOnly("1","2","3");

    }
}
