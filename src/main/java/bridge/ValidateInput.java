package bridge;

public class ValidateInput {

    public void validateBridgeSize(String input) {
        if (!checkIsNumber(input) || !checkNumberInRange(input)) {
            throw new IllegalArgumentException(ExceptionHandler.BRIDGE_SIZE_EXCEPTION);
        }
    }

    public boolean checkIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) < '0' || input.charAt(i) > '9')
                return false;
        }
        return true;
    }

    public boolean checkNumberInRange(String input) {
        int inputNumber = Integer.parseInt(input);
        return inputNumber >= 3 && 20 >= inputNumber;
    }

    public void validateMoveAlphabet(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ExceptionHandler.MOVE_ALPHABET_EXCEPTION);
        }
    }

    public void validateGameCommand(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(ExceptionHandler.GAME_COMMAND_EXCEPTION);
        }
    }
}
