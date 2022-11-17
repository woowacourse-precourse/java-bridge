package bridge;

import static bridge.InputView.inputBridgeSize;

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
}
