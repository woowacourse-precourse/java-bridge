package bridge.view;

import bridge.messages.ErrorMessage;
import bridge.messages.Message;

public class Validator {
    private static final InputView inputView = new InputView();

    /**
     * 다리 길이의 유효성 검사
     */

    public static void validateInputSizeException(String inputSize) {
        validateInputSizeNull(inputSize);
        validateInputSizeType(inputSize);
        validateInputSize(Integer.parseInt(inputSize));
    }

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
    public static void validateInputDirection(String inputDirection) {
        try {
            if (!inputDirection.equals(Message.UP.getMessage()) && !inputDirection.equals(Message.Down.getMessage())) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_MOVE_INPUT.getErrorMessage());
            inputView.inputMovingDirection();
        }
    }

    public static void validateInputDirectionLowerCase(String inputDirection) {
        char check = inputDirection.charAt(0);
        try {
            if (!Character.isUpperCase(check)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_MOVE_INPUT_LOWERCASE.getErrorMessage());
            inputView.inputMovingDirection();
        }
    }

    public static void validateInputDirectionNull(String inputDirection) {
        try {
            if (inputDirection.length() == 0) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println(ErrorMessage.INPUT_NULL.getErrorMessage());
            inputView.inputMovingDirection();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부 유효성 검사
     */
    public static void validateInputGameRestart(String inputRestart) {
        try {
            if (!inputRestart.equals(Message.RESTART.getMessage()) && !inputRestart.equals(Message.QUIT.getMessage())) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_RESTART_INPUT.getErrorMessage());
            inputView.inputGameRestart();
        }
    }

    public static void validateInputGameRestartLowerCase(String inputRestart) {
        char check = inputRestart.charAt(0);
        try {
            if (!Character.isUpperCase(check)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_MOVE_INPUT_LOWERCASE.getErrorMessage());
            inputView.inputGameRestart();
        }
    }

    public static void validateInputGameRestartNull(String inputRestart) {
        try {
            if (inputRestart.length() == 0) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println(ErrorMessage.INPUT_NULL.getErrorMessage());
            inputView.inputGameRestart();
        }
    }
}
