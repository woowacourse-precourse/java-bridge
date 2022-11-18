package bridge.validator;

public enum InputType {
    MOVE("U", "D"),
    RETRY("R","Q");

    private final String validInput1;
    private final String validInput2;

    InputType(String validInput1, String validInput2) {
        this.validInput1 = validInput1;
        this.validInput2 = validInput2;
    }

    public boolean isValidInput(String input) {
        return input.equals(validInput1) || input.equals(validInput2);
    }
}
