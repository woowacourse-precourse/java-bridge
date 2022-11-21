package enumCollections;

public enum AvailableInput {
    BRIDGE_MINIMUM_SIZE("3"),
    BRIDGE_MAXIMUM_SIZE("20"),
    QUIT_GAME("Q"),
    RETRY_GAME("R");

    private String userInput;

    AvailableInput(String userInput) {
        this.userInput = userInput;
    }

    public static String get(AvailableInput occasion) {
        return occasion.userInput;
    }

    public static boolean isGameCommand(String input) {
        return input.equals(QUIT_GAME.userInput) || input.equals(RETRY_GAME.userInput);
    }

    public static int getBridgeSizeRange(AvailableInput range) {
        return Integer.valueOf(get(range));
    }
}
