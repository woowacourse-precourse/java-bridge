package bridge;


import bridge.constant.Error;

public class Exception {

    public static int validateBridgeSize(String input) {
        if (validateInputEmpty(input)) {
            throw new IllegalArgumentException(Error.ERROR_EMPTY.getError());
        }
        if (validateInputtype(input) || validateInputrange(input)) {
            throw new IllegalArgumentException(Error.ERROR_RANGE.getError());
        }
        return Integer.parseInt(input);
    }

    private static boolean validateInputtype(String input) {
        if (input.matches("^[a-zA-Z]*$")) {
            return true;
        }
        return false;
    }

    private static boolean validateInputrange(String input) {
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < 3 || bridgeSize > 20) {
            return true;
        }
        return false;
    }


    public static String validateMoving(String input) {
        if (validateInputEmpty(input)) {
            throw new IllegalArgumentException(Error.ERROR_EMPTY.getError());
        }
        if (validateMovinginput(input))
            throw new IllegalArgumentException(Error.ERROR_MOVING.getError());
        return input;
    }

    private static boolean validateMovinginput(String input) {
        if (input.matches("[^UD]")) {
            return true;
        }
        return false;
    }

    public static String validateGameCommand(String restartInput) {
        if (validateInputEmpty(restartInput)) {
            throw new IllegalArgumentException(Error.ERROR_EMPTY.getError());
        }
        if (validateGameCommandinput(restartInput)) {
            throw new IllegalArgumentException(Error.ERROR_RESTART.getError());
        }
        return restartInput;
    }

    private static boolean validateGameCommandinput(String restartInput) {
        if (restartInput.matches("[^RQ]")) {
            return true;
        }
        return false;
    }

    private static boolean validateInputEmpty(String input) {
        if (input.equals("")) {
            return true;
        }
        return false;
    }
}
