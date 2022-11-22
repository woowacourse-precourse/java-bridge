package bridge.util.validator;

import bridge.util.Validator;

import static bridge.util.validator.BlankValidator.isBlank;

public class BridgeLengthValidator implements Validator {
    private final String BLANK_ERROR = "[ERROR] 값을 입력해주세요.";
    private final String NON_DIGIT_ERROR = "[ERROR] 숫자를 입력해주세요.";
    private final String VALUE_RANGE_ERROR = "[ERROR] 3에서 20사이의 값을 입력해주세요.";
    private final int MIN_BRIDGE_LENGTH = 3;
    private final int MAX_BRIDGE_LENGTH = 20;

    @Override
    public String validate(String input) {
        isBlank(input, BLANK_ERROR);
        isDigit(input);
        isBetween(input);
        return input;
    }

    private void isDigit(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NON_DIGIT_ERROR);
        }
    }

    private void isBetween(String number) {
        int bl = Integer.parseInt(number);
        if (!(bl >= MIN_BRIDGE_LENGTH && bl <= MAX_BRIDGE_LENGTH)) {
            throw new IllegalArgumentException(VALUE_RANGE_ERROR);
        }
    }
}
