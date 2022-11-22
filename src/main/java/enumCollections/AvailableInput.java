package enumCollections;

public enum AvailableInput {
    BRIDGE_MINIMUM_SIZE("3"),
    BRIDGE_MAXIMUM_SIZE("20"),
    QUIT_COMMAND("Q"),
    RETRY_COMMAND("R"),
    NUMERIC_RANGE("^[0-9]*$");

    private String userInput;

    AvailableInput(String userInput) {
        this.userInput = userInput;
    }

    public String getUserInput() {
        return this.userInput;
    }

    public static boolean isGameCommand(String input) {
        return input.equals(QUIT_COMMAND.userInput) || input.equals(RETRY_COMMAND.userInput);
    }

    public static int getBridgeMinimumSizeValue() {
        return Integer.valueOf(BRIDGE_MINIMUM_SIZE.userInput);
    }

    public static int getBridgeMaximumSizeValue() {
        return Integer.valueOf(BRIDGE_MAXIMUM_SIZE.userInput);
    }
}