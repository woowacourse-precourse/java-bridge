package bridge.util;

public class InputValidator {
    private static final String BLANK_INPUT_MSG = "비어 있는 입력값 입니다.";

    public void validateBridgeSize(String userInput) {
        validateBlank(userInput);
    }

    private void validateBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_MSG);
        }
    }
}
