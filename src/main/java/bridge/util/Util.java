package bridge.util;

import java.util.regex.Pattern;

public class Util {
    private static final Pattern INPUT_REGEX = Pattern.compile("^[0-9]*$");

    public static int convertStringToInt(String input) {
        validateInputType(input);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력 범위를 초과하였습니다.");
        }
    }

    public static void validateInputType(String input) {
        if (!INPUT_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }
}
