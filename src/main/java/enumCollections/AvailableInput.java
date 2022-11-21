package enumCollections;

public enum AvailableInput {
    BRIDGE_MINIMUM_SIZE("3"),
    BRIDGE_MAXIMUM_SIZE("20"),
    QUIT_COMMAND("Q"),
    RETRY_COMMAND("R");

    private String userInput;

    AvailableInput(String userInput) {
        this.userInput = userInput;
    }

    public static String get(AvailableInput occasion) {
        return occasion.userInput;
    }

    public static boolean isGameCommand(String input) {
        return input.equals(QUIT_COMMAND.userInput) || input.equals(RETRY_COMMAND.userInput);
    }

    public static int getBridgeSizeRange(AvailableInput range) {
        return Integer.valueOf(get(range));
    }

    public static String getRetryCommandValue() {
        return RETRY_COMMAND.userInput;
    }

    public static int getBridgeMinimumSizeValue() {
        return Integer.valueOf(BRIDGE_MINIMUM_SIZE.userInput);
    }

    public static int getBridgeMaximumSizeValue() {
        return Integer.valueOf(BRIDGE_MAXIMUM_SIZE.userInput);
    }
}
