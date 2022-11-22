package bridge.exception;

import bridge.domain.model.BridgeType;
import bridge.domain.model.Command;

public class ExceptionHandler {
    public static void checkIsDigit(String checkNumber) {
        for (int i = 0; i < checkNumber.length(); i++) {
            checkEachIsDigit(checkNumber.charAt(i));
        }
    }

    public static void checkEachIsDigit(char checkNumber) {
        if (!Character.isDigit(checkNumber)) {
            throw new InputNotDigitException();
        }
    }

    public static void checkBridgeLength(int length) {
        if (length < 3 || length > 20) {
            throw new InputOutOfRangeException();
        }
    }

    public static void checkMoving(String moving) {
        if (!(moving.equals(BridgeType.UP.getType()) || moving.equals(BridgeType.DOWN.getType()))) {
            throw new InputInvalidMovingException();
        }
    }

    public static void checkCommand(String command) {
        if (!(command.equals(Command.RETRY.getSymbol()) || command.equals(Command.QUIT.getSymbol()))) {
            throw new InputInvalidCommandException();
        }
    }
}
