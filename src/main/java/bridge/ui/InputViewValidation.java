package bridge.ui;

import java.util.regex.Pattern;

public class InputViewValidation {

    private final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    private final String ERROR_NOT_INTEGER = "[ERROR] 숫자가 아닙니다.";
    private final String ERROR_NOT_IN_RANGE = "[ERROR] 숫자가 범위를 벗어났습니다.";


    public void validateIsInteger(String input) {
        if (!NUMBER_PATTERN.matcher(input).find()) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    public void validateIsInRange(String input) {
        int number = Integer.parseInt(input);
        if (number < 3 || number > 20) {
            throw new IllegalArgumentException(ERROR_NOT_IN_RANGE);
        }
    }
}
