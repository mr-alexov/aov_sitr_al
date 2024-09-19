package tests.libs;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static snippets.FakerSnippets.getRandomNumberString;
import static org.assertj.core.api.Assertions.*;

public class FakerTests {

    Faker faker = new Faker();

    @Disabled
    @Test
    void fakerOptionTest() {

        Set<String> results = new HashSet<>();

        for (int i = 0; i < 50; i++) {
            results.add(getRandomNumberString());
        }

        assertThat(results).containsOnly("1","2","3");

    }


    @Test
    void fakerDateTest() {
        Date myDate = faker.date().birthday(17, 70);

        SimpleDateFormat yearFormatter = new SimpleDateFormat("yyyy");

        String year = yearFormatter.format(myDate);

        System.out.println(year);


    }
}
