package bridge.Domain;



public class InputConverter {
    public static int convertToInt(String input) throws IllegalArgumentException {
        try {
            InputValidator.validateNumberInput(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }

        return Integer.parseInt(input);
    }
}
