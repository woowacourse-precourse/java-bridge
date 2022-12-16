package bridge.view;

import bridge.util.BridgeGameStatus;
import bridge.util.BridgeShapeInfo;
import bridge.util.BridgeSize;
import bridge.util.ExceptionPhrases;

public class InputException {
    public static void userInputEmptyException(String userInput) {
        if (userInput.isEmpty() || userInput.isBlank()) {
            throw new IllegalArgumentException(ExceptionPhrases.IS_EMPTY_INPUT.getPharases());
        }
    }

    public static void notNumberException(String userInput) {
        userInput.chars().forEach(eachInput -> {
            if (!isNumber(eachInput)) {
                throw new IllegalArgumentException(ExceptionPhrases.IS_NOT_NUMBER.getPharases());
            }
        });
    }

    public static boolean isNumber(int eachInput) {
        return Character.isDigit(eachInput);
    }

    public static void outOfBridgeSizeException(int userInput) {
        if (userInput < BridgeSize.BRIDGE_MIN_SIZE.getSize() || userInput > BridgeSize.BRIDGE_MAX_SIZE.getSize()) {
            throw new IllegalArgumentException(ExceptionPhrases.IS_OUTOF_BRIDGE_SIZE.getPharases());
        }
    }

    public static void notMoveCommandException(String userInput) {
        if (!(getBridgeShape(BridgeShapeInfo.UP).equals(userInput) || getBridgeShape(BridgeShapeInfo.DOWN).equals(userInput))) {
            throw new IllegalArgumentException(ExceptionPhrases.IS_NOT_MOVE_COMMAND.getPharases());
        }
    }

    public static void notGameCommandException(String userInput) {
        if (!(getGameStatus(BridgeGameStatus.RESTART).equals(userInput) || getGameStatus(BridgeGameStatus.QUIT).equals(userInput))) {
            throw new IllegalArgumentException(ExceptionPhrases.IS_NOT_STATUS_COMMAND.getPharases());
        }
    }

    private static String getBridgeShape(BridgeShapeInfo bridgeShape) {
        return bridgeShape.getBridgeShape();
    }

    private static String getGameStatus(BridgeGameStatus gameStatus) {
        return gameStatus.getGameStatus();
    }

}
