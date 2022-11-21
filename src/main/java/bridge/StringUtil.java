package bridge;

import java.util.regex.Pattern;

public class StringUtil {
    public static boolean isNumber(String input) {
        return input != null && Pattern.matches("^[0-9]+$", input);
    }
}
