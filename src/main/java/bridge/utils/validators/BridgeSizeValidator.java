package bridge.utils.validators;

import java.util.regex.Pattern;

public class BridgeSizeValidator {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;
    private static final String PATTERN = "^[0-9]*$";
    private static final String ERROR_BLANK = "[ERROR] 값을 입력해주세요.";
    private static final String ERROR_TYPE = "[ERROR] 숫자만 입력해야 합니다.";
    private static final String ERROR_RANGE = "[ERROR] 3이상 20이하의 길이를 입력해야 합니다.";

    String size;

    public BridgeSizeValidator(String size) {
        this.size = size;
        validate();
    }

    private void validate() {
        validateInputNonBlank();
        validateInputType();
        validateInputSize();
    }

    private void validateInputNonBlank() {
        if (size.equals("")) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private void validateInputType() {
        if (!Pattern.matches(PATTERN, size)) {
            throw new IllegalArgumentException(ERROR_TYPE);
        }
    }

    private void validateInputSize() {
        if (Integer.parseInt(size) < MIN_LENGTH || Integer.parseInt(size) > MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }
}
