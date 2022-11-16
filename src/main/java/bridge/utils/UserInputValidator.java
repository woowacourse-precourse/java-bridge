package bridge.utils;

import static bridge.domain.BridgeMaker.SPACE_NAME;

public class UserInputValidator {

    private static final int MINIMUM_BRIDGE_LENGTH = 3;
    private static final int MAXIMUM_BRIDGE_LENGTH = 20;
    private static final int SIZE_OF_SPACE_TO_MOVE = 1;
    private static final String ERROR_MESSAGE_OUT_OF_RANGE_BRIDGE_LENGTH = "[ERROR] 다리 길이는 3이상 20이하여야 합니다.";
    private static final String ERROR_MESSAGE_NOT_DIGIT = "[ERROR] 다리 길이는 숫자만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_VALID_SPACE_NAME = "[ERROR] 이동할 칸은 'U' 혹은 'D'만 입력 가능합니다.";
    private static final String ERROR_MESSAGE_NOT_VALID_SPACE_INPUT_SIZE = "[ERROR] 이동할 칸은 하나의 문자만 입력 가능합니다.";

    public static void validateBridgeLength(String bridgeLength) {
        isDigit(bridgeLength);
        isValidLength(Integer.parseInt(bridgeLength));
    }

    public static void validateSpaceToMove(String spaceToMove) {
        isValidSpaceInputSize(spaceToMove);
        isValidSpaceName(spaceToMove);
    }

    private static void isDigit(String bridgeLength) {
        try {
            Integer.parseInt(bridgeLength);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT);
        }
    }

    private static void isValidLength(int bridgeLength) {
        if (bridgeLength < MINIMUM_BRIDGE_LENGTH || bridgeLength > MAXIMUM_BRIDGE_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE_BRIDGE_LENGTH);
        }
    }

    private static void isValidSpaceInputSize(String spaceToMove) {
        if (spaceToMove.length() != SIZE_OF_SPACE_TO_MOVE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_SPACE_INPUT_SIZE);
        }
    }

    private static void isValidSpaceName(String spaceToMove) {
        if (!SPACE_NAME.contains(spaceToMove)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_SPACE_NAME);
        }
    }
}
