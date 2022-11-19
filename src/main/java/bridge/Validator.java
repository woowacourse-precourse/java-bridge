package bridge;

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
        if (!(direction.equals("U") || direction.equals("D"))) {
            throw new IllegalArgumentException(ErrorState.DIRECTION);
        }
    }

    public static void command(String command) {
        if(!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException(ErrorState.COMMAND);
        }
    }
}
