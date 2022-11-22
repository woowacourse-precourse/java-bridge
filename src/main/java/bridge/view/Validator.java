package bridge.view;

import bridge.messages.ErrorMessage;
import bridge.messages.Message;

public class Validator {
    private static final int MIN_NUM = 3;
    private static final int MAX_NUM = 20;
    private static final int ZERO = 0;
    private static final char CHAR_ZERO = '0';
    private static final char CHAR_NINE = '9';

    /**
     * private의 입력 값 별 유효성 검사 메서드들을 예외 발생 순서대로 한번에 실행시키는 메서드.
     */
    public static void validateInputSizeException(String inputSize) {
        validateInputSizeNull(inputSize);
        validateInputSizeType(inputSize);
        validateInputSize(Integer.parseInt(inputSize));
    }

    public static void validateInputDirectionException(String inputDirection) {
        validateInputDirectionNull(inputDirection);
        validateInputNumber(inputDirection);
        validateInputDirectionLowerCase(inputDirection);
        validateInputDirection(inputDirection);
    }

    public static void validateInputGameRestartException(String inputRestart) {
        validateInputGameRestartNull(inputRestart);
        validateInputNumber(inputRestart);
        validateInputGameRestartLowerCase(inputRestart);
        validateInputGameRestart(inputRestart);
    }

    /**
     * 다리 길이의 유효성 검사
     */
    private static void validateInputSize(int bridgeSize) {
        if (bridgeSize < MIN_NUM || bridgeSize > MAX_NUM) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INPUT_RANGE.getErrorMessage());
        }
    }

    private static void validateInputSizeType(String inputSize) {
        final String regex = "[0-9]+";
        if (!inputSize.matches(regex)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INPUT_TYPE.getErrorMessage());
        }
    }

    private static void validateInputSizeNull(String inputSize) {
        if (inputSize.length() == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    /**
     * 플레이어가 이동할 칸 유효성 검사
     */
    private static void validateInputDirection(String inputDirection) {
        if (!inputDirection.equals(Message.UP.getMessage()) && !inputDirection.equals(Message.Down.getMessage())) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_MOVE_INPUT.getErrorMessage());
        }
    }

    private static void validateInputDirectionLowerCase(String inputDirection) {
        char check = inputDirection.charAt(ZERO);
        if (!Character.isUpperCase(check)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_MOVE_INPUT_LOWERCASE.getErrorMessage());
        }
    }

    private static void validateInputDirectionNull(String inputDirection) {
        if (inputDirection.length() == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부 유효성 검사
     */
    private static void validateInputGameRestart(String inputRestart) {
        if (!inputRestart.equals(Message.RESTART.getMessage()) && !inputRestart.equals(Message.QUIT.getMessage())) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_RESTART_INPUT.getErrorMessage());
        }
    }

    private static void validateInputGameRestartLowerCase(String inputRestart) {
        char check = inputRestart.charAt(ZERO);
        if (!Character.isUpperCase(check)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_RESTART_INPUT_LOWERCASE.getErrorMessage());
        }
    }

    private static void validateInputGameRestartNull(String inputRestart) {
        if (inputRestart.length() == ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    /**
     * 이동할 칸 입력과 게임을 재시작 여부 입렵에 숫자 입력 여부 유효성 검사
     */
    private static void validateInputNumber(String input) {
        char check = input.charAt(ZERO);
        if (check >= CHAR_ZERO && check <= CHAR_NINE) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_INPUT_NUMBER.getErrorMessage());
        }
    }
}
