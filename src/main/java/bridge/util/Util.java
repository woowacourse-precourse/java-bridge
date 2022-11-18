package bridge.util;

import java.util.List;
import java.util.regex.Pattern;

public class Util {
    public static final List<String> MOVING_OPTIONS = List.of("U", "D");
    private static final Pattern INPUT_REGEX = Pattern.compile("^[0-9]*$");

    public static int convertStringToInt(String input) {
        validateBridgeSizeType(input);
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

    public static void validateMovingInput(String input) {
        if (!MOVING_OPTIONS.contains(input)) {
            throw new IllegalArgumentException("U/D 중 이동할 칸을 입력해 주세요.");
        }
    }
}
