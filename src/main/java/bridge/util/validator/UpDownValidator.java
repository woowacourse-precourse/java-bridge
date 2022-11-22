package bridge.util.validator;

import bridge.util.Validator;

import static bridge.util.validator.BlankValidator.isBlank;

public class UpDownValidator implements Validator {
    private final String UP_VALUE = "U";
    private final String DOWN_VALUE = "D";
    private final String BLANK_ERROR = "[ERROR] 값을 입력해주세요.";
    private final String UP_DOWN_ERROR = "[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력해주세요.";

    @Override
    public String validate(String input) {
        isBlank(input, BLANK_ERROR);
        isUpOrDown(input);
        return input;
    }

    private void isUpOrDown(String upDown) {
        if (!upDown.equals(UP_VALUE) && !upDown.equals(DOWN_VALUE)) {
            throw new IllegalArgumentException(UP_DOWN_ERROR);
        }
    }
}