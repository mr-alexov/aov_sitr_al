package snippets;

import com.github.javafaker.Faker;

public class FakerSnippets {

    public static String getRandom() {
        String[] numbers =
                {"1", "2", "3"};
        return new Faker().options().option(numbers);
    }

}
