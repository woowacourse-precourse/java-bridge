package bridge.validator;

public enum InputType {
    MOVE("U", "D"),
    RETRY("R","Q");

    private static final String RESTART_INPUT = "R";
    private final String validInput1;
    private final String validInput2;

    InputType(String validInput1, String validInput2) {
        this.validInput1 = validInput1;
        this.validInput2 = validInput2;
    }

    public static boolean isRestartInput(String input) {
        return input.equals(RESTART_INPUT);
    }

    public boolean isValidInput(String input) {
        return input.equals(validInput1) || input.equals(validInput2);
    }
}
