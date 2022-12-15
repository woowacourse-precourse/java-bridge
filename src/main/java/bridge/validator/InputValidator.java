package bridge.validator;

import static bridge.messages.ErrorMessage.NON_NUMERIC_BRIDGE_SIZE_ERROR;
import static bridge.messages.ErrorMessage.OUTBOUND_BRIDGE_SIZE_ERROR;

import bridge.messages.ErrorMessage;

public class InputValidator {
    private static final int MINIMUM_SIZE = 3;
    private static final int MAXIMUM_SIZE = 20;
    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String RETRY = "R";
    public static final String QUIT = "Q";

    public static int validateBridgeSize(String inputBridgeSize) {
        int bridgeSize = getAnInt(inputBridgeSize);
        if (bridgeSize < MINIMUM_SIZE || bridgeSize > MAXIMUM_SIZE) {
            throw new IllegalArgumentException(OUTBOUND_BRIDGE_SIZE_ERROR);
        }
        return bridgeSize;
    }

    private static int getAnInt(final String inputBridgeSize) {
        try {
            return Integer.parseInt(inputBridgeSize);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_NUMERIC_BRIDGE_SIZE_ERROR);
        }
    }

    public static String validateBlock(final String inputBlock) {
        if (!inputBlock.equals(UP) && !inputBlock.equals(DOWN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BLOCK_COMMAND_ERROR);
        }
        return inputBlock;
    }

    public static String validateGameCommand(final String inputGameCommand) {
        if (!inputGameCommand.equals(RETRY) && !inputGameCommand.equals(QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COMMAND_ERROR);
        }
        return inputGameCommand;
    }
}
