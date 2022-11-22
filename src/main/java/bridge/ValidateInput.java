package bridge;

public class ValidateInput {

    public void validateBridgeSize(String input) {
        if (!validateIsNumber(input) || !validateNumberInRange(input)) {
            throw new IllegalArgumentException(ExceptionHandler.BRIDGE_SIZE_EXCEPTION);
        }
    }

    public boolean validateIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) < '0' || input.charAt(i) > '9')
                return false;
        }
        return true;
    }

    public boolean validateNumberInRange(String input) {
        int inputNumber = Integer.parseInt(input);
        return inputNumber >= 3 && 20 >= inputNumber;
    }

    public boolean validateMoveAlphabet(String input) {
        return input.equals("U") || input.equals("D");
    }

    public boolean validateGameCommand(String input) {
        return input.equals("R") || input.equals("Q");
    }
}
