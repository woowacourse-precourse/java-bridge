package bridge;

public class CustomException {
    public static final String ERROR_HEAD = "[ERROR] ";
    public static final String NOT_NULL = "입력은 NULL이 불가능합니다.";
    public static final String NOT_BLANK = "입력은 공백이 불가능합니다.";
    public static final String NOT_NUMBER = "입력이 숫자로 이루어져있지 않습니다.";
    public static final String NOT_START_ZERO = "다리 길이는 0으로 시작할 수 없습니다.";
    public static final String OUT_OF_RANGE = "다리길이가 3~20 이외의 수입니다.";
    public static final String OUT_OF_COMMAND_RANGE = "명령의 길이가 다릅니다.";
    public static final String OUT_OF_MOVE_RANGE = "이동의 길이가 다릅니다.";
    public static final String NOT_MOVING_COMMAND = "유효하지 않은 이동 명령입니다.";
    public static final String NOT_QUIT_RETRY = "유효하지 않은 게임 명령입니다.";

    public static void InputNotNullException() {
        throw new IllegalArgumentException(ERROR_HEAD + NOT_NULL);
    }

    public static void NotBlankException() {
        throw new IllegalArgumentException(ERROR_HEAD + NOT_BLANK);
    }

    public static void NotNumberException() {
        throw new IllegalArgumentException(ERROR_HEAD + NOT_NUMBER);
    }

    public static void StartWithZeroException() {
        throw new IllegalArgumentException(ERROR_HEAD + NOT_START_ZERO);
    }

    public static void NotNumberRangeException() {
        throw new IllegalArgumentException(ERROR_HEAD + OUT_OF_RANGE);
    }

    public static void CommandLengthException() {
        throw new IllegalArgumentException(ERROR_HEAD + OUT_OF_COMMAND_RANGE);
    }
    public static void MoveLengthException() {
        throw new IllegalArgumentException(ERROR_HEAD + OUT_OF_MOVE_RANGE);
    }

    public static void NoSuchCommandException() {
        throw new IllegalArgumentException(ERROR_HEAD + NOT_QUIT_RETRY);
    }

    public static void NoSuchMovingException() {
        throw new IllegalArgumentException(ERROR_HEAD + NOT_MOVING_COMMAND);
    }
}
