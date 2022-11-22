package bridge;

import bridge.exception.BridgeSizeWrongException;
import bridge.exception.CommandInputWrongException;
import bridge.exception.MoveInputWrongException;

public class Validator {

    public static String validateBridgeSize(String input) {
        System.out.println();
        if (!input.matches("^[0-9]+") || !isInRange(Integer.parseInt(input))) {
            throw new BridgeSizeWrongException();
        }
        return input;
    }

    public static boolean isInRange(int input) {
        if (input >= 3 && input <= 20) {
            return true;
        }
        return false;
    }

    public static String validateMoveInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new MoveInputWrongException();
        }
        return input;
    }

    public static String validateCommand(String input) {
        if (!input.equals("Q") && !input.equals("R")) {
            throw new CommandInputWrongException();
        }
        return input;
    }
}
