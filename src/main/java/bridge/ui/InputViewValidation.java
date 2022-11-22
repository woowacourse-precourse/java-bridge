package bridge.ui;

import java.util.regex.Pattern;

public class InputViewValidation {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private static final String ERROR_NOT_INTEGER = "[ERROR] 숫자가 아닙니다.";
    private static final String ERROR_NOT_IN_RANGE = "[ERROR] 숫자가 범위를 벗어났습니다.";
    private static final String ERROR_NOT_U_OR_D = "[ERROR] U나 D를 입력하셔야합니다.";
    private static final String ERROR_NOT_R_OR_Q = "[ERROR] R이나 Q를 입력하셔야합니다.";

    public static void validateIsInteger(String input) {
        if (!NUMBER_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    public static void validateIsInRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(ERROR_NOT_IN_RANGE);
        }
    }

    public static void validateIsUorD(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ERROR_NOT_U_OR_D);
        }
    }

    public static void validateIsRorQ(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(ERROR_NOT_R_OR_Q);
        }
    }
}
