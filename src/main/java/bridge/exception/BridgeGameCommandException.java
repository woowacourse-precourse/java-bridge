package bridge.exception;

public class BridgeGameCommandException {

    private static final String ERROR_INVALID_COMMAND_SIZE = "한 글자만 입력해 주세요.";
    private static final String ERROR_IS_NOT_UPPERCASE_CHARACTER = "대문자 알파벳을 입력해 주세요.";
    private static final String ERROR_INVALID_MOVING_COMMAND_CHARACTER = "'U' 또는 'D' 가 아니면 다리 건너기를 할 수 없습니다.";
    private static final String ERROR_INVALID_RETRY_COMMAND_CHARACTER = "'R' 또는 'Q' 가 아니면 게임을 종료하거나 재시작 할 수 없습니다.";

    public static void invalidCommandSize() {
        throw new IllegalArgumentException(ERROR_INVALID_COMMAND_SIZE);
    }

    public static void isNotUpperCaseCharacter() {
        throw new IllegalArgumentException(ERROR_IS_NOT_UPPERCASE_CHARACTER);
    }

    public static void invalidMovingCommandCharacter() {
        throw new IllegalArgumentException(ERROR_INVALID_MOVING_COMMAND_CHARACTER);
    }

    public static void invalidRetryCommandCharacter() {
        throw new IllegalArgumentException(ERROR_INVALID_RETRY_COMMAND_CHARACTER);
    }
}
