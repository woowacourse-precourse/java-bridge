package bridge.utils.validators;

import java.util.regex.Pattern;

public class BridgeSizeValidator {

    String size;
    private final static String PATTERN = "^[0-9]*$";
    private final static int MIN_LENGTH = 3;
    private final static int MAX_LENGTH = 20;

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
            throw new IllegalArgumentException("[ERROR] 값을 넣어야합니다.");
        }
    }

    private void validateInputType() {
        if (!Pattern.matches(PATTERN, size)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private void validateInputSize() {
        if (Integer.parseInt(size) < MIN_LENGTH || Integer.parseInt(size) > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 길이를 입력해야 합니다.");
        }
    }

}
