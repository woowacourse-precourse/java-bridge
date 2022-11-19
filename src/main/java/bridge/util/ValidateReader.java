package bridge.util;

import java.util.function.Function;

public class ValidateReader {

    public static <T> T readUntilValidate(Function<Void, T> expression) {
        T input = null;
        do {
            try {
                input = expression.apply(null);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        } while (input == null);

        return input;
    }
}
