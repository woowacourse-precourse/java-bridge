package bridge;

import java.util.regex.Pattern;

public class ValidateInput {
    public static void bridgeSize(String input) {
        final String INPUT_PATTERN = "^[3-9]$|^1[0-9]$|^20$";
        final String EXCEPTION_MESSAGE = "[ERROR] 다리의 길이는 3 이상 20 이하의 숫자만 입력 가능합니다.";

        boolean isMatch = Pattern.matches(INPUT_PATTERN, input);

        if (!isMatch) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public static void moving(String input) {
        final String INPUT_PATTERN = "^[UD]$";
        final String EXCEPTION_MESSAGE = "[ERROR] U 또는 D를 제외한 문자가 입력되었습니다.";

        boolean isMatch = Pattern.matches(INPUT_PATTERN, input);

        if (!isMatch) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public static void gameCommand(String input) {
        final String INPUT_PATTERN = "^[RQ]$";
        final String EXCEPTION_MESSAGE = "[ERROR] R 또는 Q를 제외한 문자가 입력되었습니다.";

        boolean isMatch = Pattern.matches(INPUT_PATTERN, input);

        if (!isMatch) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}