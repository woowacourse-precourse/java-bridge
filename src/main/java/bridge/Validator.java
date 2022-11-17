package bridge;

import static bridge.InputView.inputBridgeSize;
import static bridge.InputView.inputMovingDirection;

public class Validator {

    /**
     * 다리 길이의 유효성 검사
     */
    public static void validateInputSize(int bridgeSize) {
        try {
            if (bridgeSize < 3 || bridgeSize > 20) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_SIZE_INPUT_RANGE.getErrorMessage());
            inputBridgeSize();
        }
    }

    public static void validateInputType(String inputSize) {
        try {
            Integer.parseInt(inputSize);
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.BRIDGE_SIZE_INPUT_TYPE.getErrorMessage());
            inputBridgeSize();
        }
    }

    public static void validateInputNull(String inputSize) {
        try {
            if (inputSize.length() == 0) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println(ErrorMessage.INPUT_NULL.getErrorMessage());
            inputBridgeSize();
        }
    }

    /**
     * 플레이어가 이동할 칸 유효성 검사
     */
    public static void validateInputDIRECTION(String inputDirection) {
        try {
            if (inputDirection != "U" && inputDirection != "D") {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_MOVE_INPUT.getErrorMessage());
            inputMovingDirection();
        }
    }

    public static void validateInputLowerCase(String inputDirection) {
        char check = inputDirection.charAt(0);
        try {
            if (!Character.isUpperCase(check)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.BRIDGE_MOVE_INPUT_LOWERCASE.getErrorMessage());
            inputMovingDirection();
        }
    }
}
