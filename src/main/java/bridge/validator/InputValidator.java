package bridge.validator;

import bridge.domain.Direction;

import static bridge.exception.Exception.*;
import static bridge.utils.constant.Constants.*;

public class InputValidator {
    public static void validateBridgeSize(String bridgeSize) {
        validateFormat(bridgeSize);
        validateRange(Integer.parseInt(bridgeSize));
    }

    public static void validateFormat(String bridgeSize) {
        try{
            Integer.parseInt(bridgeSize);
        } catch(NumberFormatException e) {
            NOT_NUMBER.throwException();
        }
    }

    public static void validateRange(int bridgeSize) {
        if(bridgeSize < MIN_RANGE || bridgeSize > MAX_RANGE) {
            OUT_OF_RANGE.throwException();
        }
    }

    public static void validateDirection(String direction) {
        Direction block = Direction.of(direction);
        if(block != Direction.UP && block != Direction.DOWN) {
            INVALID_DIRECTION.throwException();
        }
    }

    public static void validateCommand(String command) {
        if(!command.equals(RETRY) && !command.equals(QUIT)) {
            INVALID_COMMAND.throwException();
        }
    }
}
