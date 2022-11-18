package bridge;

import java.util.regex.Pattern;

public class Validation {
    public static void isPositiveInteger(String input) {
        String pattern = "^[^0]\\d*";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException("[ERROR} 다리 개수는 양의 정수이어야 합니다.");
        }
    }
}
