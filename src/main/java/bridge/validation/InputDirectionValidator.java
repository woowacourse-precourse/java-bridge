package bridge.validation;

import static bridge.constant.Direction.isDirectionExist;

public class InputDirectionValidator {

    private static final String INVALID_DIRECTION = "이동할 칸은 'U' 혹은 'D'로 입력해야 합니다.";

    public static void validateInputDirection(String direction) {
        if (!isDirectionExist(direction)) {
            throw new IllegalArgumentException(INVALID_DIRECTION);
        }
    }
}