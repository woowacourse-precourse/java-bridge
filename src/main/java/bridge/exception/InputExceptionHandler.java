package bridge.exception;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputExceptionHandler {
    private static final String NULL_INPUT_ERROR_MSG = "[ERROR] 입력된 값이 없습니다.";
    private static final String NOT_INTEGER_ERROR_MSG = "[ERROR] 숫자 외 다른 문자를 입력할 수 없습니다.";
    private static final String BRIDGE_SIZE_ERROR_MSG = "[ERROR] 다리 길이는 3~20 사이의 숫자여야 합니다";
    private static final String MOVING_ERROR_MSG = "[ERROR] U, D 외 다른 값을 입력할 수 없습니다.";
    private static final String GAME_COMMAND_ERROR_MSG = "[ERROR] R, Q 외 다른 값을 입력할 수 없습니다.";

    public static String nullInputExceptionHandler() {
        try {
            return Console.readLine();
        } catch (Exception exception) {
            throw new NoSuchElementException(NULL_INPUT_ERROR_MSG);
        }
    }

    public static int bridgeSizeExceptionHandler(String bridgeSize) {
        try {
            final int bridgeSizeToInteger = Integer.parseInt(bridgeSize);
            if (bridgeSizeToInteger >= 3 && bridgeSizeToInteger <= 20) {
                return bridgeSizeToInteger;
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MSG);
        }
        throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MSG);
    }

    public static String movingExceptionHandler(String moving) {
        if (!moving.matches("^[UD]$")) {
            throw new IllegalArgumentException(MOVING_ERROR_MSG);
        }
        return moving;
    }

    public static String gameCommandExceptionHandler(String gameCommand) {
        if (!gameCommand.matches("^[RQ]$")) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MSG);
        }
        return gameCommand;
    }
}
