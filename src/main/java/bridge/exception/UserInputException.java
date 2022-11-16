package bridge.exception;

public class UserInputException {

    private static final String ERROR_IS_NOT_NUMBER = "[ERROR] 숫자를 입력해 주세요.";
    private static final String ERROR_INVALID_BRIDGE_SIZE = "[ERROR] 다리의 길이는 3 이상 20 미만 이어야 합니다.";
    private static final String ERROR_IS_NOT_UPPERCASE_CHARACTER = "[ERROR] 대문자 알파벳을 입력해 주세요.";
    private static final String ERROR_INVALID_MOVING_COMMAND_SIZE = "[ERROR] 한 글자만 입력해 주세요.";
    private static final String ERROR_INVALID_MOVING_COMMAND_CHARACTER = "[ERROR] \'U\' 또는 \'D\'만 입력해 주세요.";

    public static void isNotNumber() {
        throw new IllegalArgumentException(ERROR_IS_NOT_NUMBER);
    }

    public static void invalidBridgeSize() {
        throw new IllegalStateException(ERROR_INVALID_BRIDGE_SIZE);
    }

    public static void isNotUpperCaseCharacter() {
        throw new IllegalArgumentException(ERROR_IS_NOT_UPPERCASE_CHARACTER);
    }

    public static void invalidMovingCommandSize() {
        throw new IllegalArgumentException(ERROR_INVALID_MOVING_COMMAND_SIZE);
    }

    public static void invalidMovingCommandCharacter() {
        throw new IllegalStateException(ERROR_INVALID_MOVING_COMMAND_CHARACTER);
    }

}
