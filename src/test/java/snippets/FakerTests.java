package snippets;

import com.github.javafaker.Faker;

public class FakerTests {

    public static String getRandom() {
        String[] genders =
                {"1", "2", "3"};
        return new Faker().options().option(genders);
    }

}
