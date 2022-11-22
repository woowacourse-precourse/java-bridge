package bridge;

import bridge.constant.InputValidationError;
import java.util.List;

public class InputValidator {
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;
    private static final List<String> COMMAND_MOVE_LIST = List.of(
            "U",
            "D"
    );
    private static final List<String> COMMAND_RETRY_LIST = List.of(
            "R",
            "Q"
    );

    public InputValidator() {

    }

    public void validateBridgeSize(int size) throws IllegalArgumentException {
        if(size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE){
            throw InputValidationError.ERROR_BRIDGE_SIZE.exception;
        }
    }

    public int validateBridgeSizeParsable(String size) throws IllegalArgumentException{
        int parsedSize;
        try {
            parsedSize = Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw InputValidationError.ERROR_BRIDGE_SIZE.exception;
        }
        return parsedSize;
    }

    public void validateMove(String dir) throws IllegalArgumentException {
        if(!COMMAND_MOVE_LIST.contains(dir)){
            throw InputValidationError.ERROR_COMMAND_MOVE.exception;
        }
    }

    public void validateGameCommand(String cmd) throws IllegalArgumentException {
        if(!COMMAND_RETRY_LIST.contains(cmd)){
            throw InputValidationError.ERROR_COMMAND_RETRY.exception;
        }
    }
}
