package bridge.view;

import bridge.messages.ErrorMessage;
import bridge.messages.Message;

public class Validator {

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
        validateInputDirectionLowerCase(inputDirection);
        validateInputDirection(inputDirection);
    }

    public static void validateInputGameRestartException(String inputRestart) {
        validateInputGameRestartNull(inputRestart);
        validateInputGameRestartLowerCase(inputRestart);
        validateInputGameRestart(inputRestart);
    }

    /**
     * 다리 길이의 유효성 검사
     */
    private static void validateInputSize(int bridgeSize) {
        try {
            if (bridgeSize < 3 || bridgeSize > 20) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INPUT_RANGE.getErrorMessage());
        }
    }

    private static void validateInputSizeType(String inputSize) {
        try {
            Integer.parseInt(inputSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_INPUT_TYPE.getErrorMessage());
        }
    }

    private static void validateInputSizeNull(String inputSize) {
        try {
            if (inputSize.length() == 0) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    /**
     * 플레이어가 이동할 칸 유효성 검사
     */
    private static void validateInputDirection(String inputDirection) {
        try {
            if (!inputDirection.equals(Message.UP.getMessage()) && !inputDirection.equals(Message.Down.getMessage())) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_MOVE_INPUT.getErrorMessage());
        }
    }

    private static void validateInputDirectionLowerCase(String inputDirection) {
        char check = inputDirection.charAt(0);
        try {
            if (!Character.isUpperCase(check)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_MOVE_INPUT_LOWERCASE.getErrorMessage());
        }
    }

    private static void validateInputDirectionNull(String inputDirection) {
        try {
            if (inputDirection.length() == 0) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            throw new NullPointerException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부 유효성 검사
     */
    private static void validateInputGameRestart(String inputRestart) {
        try {
            if (!inputRestart.equals(Message.RESTART.getMessage()) && !inputRestart.equals(Message.QUIT.getMessage())) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_RESTART_INPUT.getErrorMessage());
        }
    }

    private static void validateInputGameRestartLowerCase(String inputRestart) {
        char check = inputRestart.charAt(0);
        try {
            if (!Character.isUpperCase(check)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_MOVE_INPUT_LOWERCASE.getErrorMessage());
        }
    }

    private static void validateInputGameRestartNull(String inputRestart) {
        try {
            if (inputRestart.length() == 0) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }
}
