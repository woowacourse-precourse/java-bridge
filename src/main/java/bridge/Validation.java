package bridge;

import bridge.domain.BridgeValue;

public class Validation {
    private final static int MIN_BRIDGE_SIZE = 3;
    private final static int MAX_BRIDGE_SIZE = 20;

    private final static String ERROR_MESSAGE = "[ERROR] ";
    private final static String NOT_NUMBER_TYPE_MESSAGE = "다리 길이는 숫자만 입력 가능합니다.";
    private final static String INVALID_NUMBER_RANGE_MESSAGE = "다리 길이는 " + MIN_BRIDGE_SIZE + "부터 " + MAX_BRIDGE_SIZE + " 사이의 숫자여야 합니다.";
    private final static String INVALID_MOVING_MESSAGE = BridgeValue.UP.getValue() + " 또는 " + BridgeValue.DOWN.getValue() + "만 입력 가능합니다.";
    private final static String INVALID_COMMAND_MESSAGE = "R" + " 또는 " + "Q" + "만 입력 가능합니다.";


    private static void isNumberType(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NUMBER_TYPE_MESSAGE);
        }
    }

    private static void isValidNumberRange(int number) {
        if (number < MIN_BRIDGE_SIZE || number > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_NUMBER_RANGE_MESSAGE);
        }
    }

    public static void validateBridgeSizeInput(String inputBrideSize) {
        isNumberType(inputBrideSize);
        isValidNumberRange(Integer.parseInt(inputBrideSize));
    }

    public static void validateMovingInput(String inputMoving) {
        if (!inputMoving.equals(BridgeValue.UP.getValue()) && !inputMoving.equals(BridgeValue.DOWN.getValue())) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_MOVING_MESSAGE);
        }
    }

    public static void validateCommandInput(String inputCommand) {
        if (!inputCommand.equals("R") && !inputCommand.equals("Q")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_COMMAND_MESSAGE);
        }
    }
}
