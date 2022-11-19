package bridge.utils.validators;

import bridge.domain.enums.Moving;

public class MovingValidator {

    private static final String ERROR_BLANK = "[ERROR] 값을 입력해주세요.";
    private static final String ERROR_ILLEGAL = "[ERROR] 대문자 U 또는 대문자 D를 입력해야 합니다.";

    String moving;

    public MovingValidator(String moving) {
        this.moving = moving;
        validate();
    }

    private void validate() {
        validateInputNonBlank();
        validateInputValue();
    }

    private void validateInputNonBlank() {
        if (moving.equals("")) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private void validateInputValue() {
        if (!moving.equals(Moving.UP.getValue()) && !moving.equals(Moving.DOWN.getValue())) {
            throw new IllegalArgumentException(ERROR_ILLEGAL);
        }
    }
}
