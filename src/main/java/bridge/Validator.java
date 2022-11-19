package bridge;

import bridge.Constants.Command;
import bridge.Constants.ErrorState;

public class Validator {
    private Validator() {}

    public static void size(String size) {
        String sizeRegex = "^([3-9]{1})$|^(1[0-9]{1})$|^20$";
        if (!size.matches(sizeRegex)) {
            throw new IllegalArgumentException(ErrorState.BRIDGE_SIZE);
        }
    }

    public static void direction(String direction) {
        if (!(direction.equals(Command.UP) || direction.equals(Command.DOWN))) {
            throw new IllegalArgumentException(ErrorState.DIRECTION);
        }
    }

    public static void command(String command) {
        if(!(command.equals(Command.RETRY) || command.equals(Command.QUIT))) {
            throw new IllegalArgumentException(ErrorState.COMMAND);
        }
    }
}
