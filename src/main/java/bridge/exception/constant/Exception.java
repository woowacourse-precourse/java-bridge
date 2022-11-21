package bridge.exception.constant;

import java.util.Arrays;

public enum Exception {
    NO_ERROR("", "예외가 발생하지 않았습니다."),
    ENTER_WRONG_LETTER_ERROR("not proper letter", Exception.ERROR + "다리 길이를 잘못 입력하셨습니다. 다리 길이는 숫자를 입력해주세요"),
    ENTER_WRONG_BRIDGE_LENGTH_RANGE_ERROR("not proper range", Exception.ERROR + "다리 길이는 3부터 20 사이를 입력해야합니다."),
    ENTER_WRONG_MOVING_WORD_ERROR("not proper moving input", Exception.ERROR + "잘못된 움직임을 입력하셨습니다. 적절한 움직임은 U 또는 D 입니다."),
    ENTER_WRONG_GAME_COMMAND_ERROR("not proper game command input", Exception.ERROR + "게임 커맨드는 재시작은 R, 종료는 Q 입니다.");

    private static final String ERROR="[ERROR]";
    private final String LEGACY_EXCEPTION;
    private final String ERROR_MESSAGE;

    Exception(String legacyException, String errorMessage){
        this.LEGACY_EXCEPTION=legacyException;
        this.ERROR_MESSAGE=errorMessage;
    }
    private static boolean isSameException(Exception exception, String legacyExceptionName){
        return exception.LEGACY_EXCEPTION.equals(legacyExceptionName);
    }

    public static Exception findException(String runtimeExceptionName){
        return Arrays.stream(Exception.values())
                .filter(exception -> isSameException(exception,runtimeExceptionName))
                .findAny().orElse(NO_ERROR);
    }
    public static String getErrorMessage(String runtimeExceptionName){
        Exception exception = Exception.findException(runtimeExceptionName);
        return exception.ERROR_MESSAGE;
    }
}
