package bridge.util;

import java.util.regex.Pattern;

public class Util {
    private static final Pattern INPUT_REGEX = Pattern.compile("^[0-9]*$");

    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("입력 범위를 초과하였습니다.");
        }
    }

    public static void validateBridgeSizeType(String input) {
        if (!INPUT_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("자연수만 입력해 주세요.");
        }
    }

    public static void validateBridgeSizeRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

}
