package enumCollections;

public enum AvailableInput {
    BRIDGE_MINUMUM_LENGTH("3"),
    BRIDGE_MAXIMUM_LENGTH("20"),
    QUIT_GAME("Q"),
    RESTART_GAME("R");

    private String userInput;

    AvailableInput(String userInput) {
        this.userInput = userInput;
    }

    public static String get(AvailableInput occasion) {
        return occasion.userInput;
    }

    public static boolean isGameCommand(String input) {
        return input.equals(QUIT_GAME) || input.equals(RESTART_GAME);
    }

    public static int getBridgeLengthRange(AvailableInput range) {
        return Integer.valueOf(get(BRIDGE_MINUMUM_LENGTH));
    }
}
