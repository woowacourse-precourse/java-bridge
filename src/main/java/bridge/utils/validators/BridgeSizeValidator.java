package bridge.utils.validators;

import bridge.utils.EnumStrings;
import java.util.regex.Pattern;

public class BridgeSizeValidator {

    String size;
    public final static int MIN_LENGTH = 3;
    public final static int MAX_LENGTH = 20;

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
        if (!Pattern.matches(EnumStrings.PATTERN.getValue(), size)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private void validateInputSize() {
        if (Integer.parseInt(size) < MIN_LENGTH || Integer.parseInt(size) > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 길이를 입력해야 합니다.");
        }
    }

}
