package bridge.util;

public class Validater {
    private static final String ERROR_MESSAGE_NOT_INT = "[ERROR] 숫자를 입력해주세요.";
    private static final String ERROR_MESSAGE_NOT_PROPER_BRIDGE_SIZE = "[ERROR] 다리 길이는 3이상 20이하의 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_PROPER_MOVE = "[ERROR] 대문자 U또는 D를 입력해주세요.";
    private static final String ERROR_MESSAGE_NOT_PROPER_COMMAND = "[ERROR] 대문자 R또는 Q를 입력해주세요.";

    public void validateBridgeSize(String input) {
        validateIsNumeric(input);
        validateBridgeSizeRange(input);
    }

    public void validateIsNumeric(String input) {
        final String REGEX = "[0-9]+";
        if(!input.matches(REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INT);
        }
    }

    public void validateBridgeSizeRange(String input) {
        int bridgeSize = Integer.valueOf(input);
        if(!(bridgeSize >= 3 && bridgeSize <= 20)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_BRIDGE_SIZE);
        }
    }

    public void validateMovingInput(String input) {
        if (!(input.equals("D") || input.equals("U"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_MOVE);
        }
    }

    public void validateGameCommandInput(String input) {
        if (!(input.equals("Q") || input.equals("R"))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_PROPER_COMMAND);
        }
    }
}
