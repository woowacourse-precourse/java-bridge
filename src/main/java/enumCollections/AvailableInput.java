package enumCollections;

public enum AvailableInput {
    QUIT_GAME("Q"),
    RESTART_GAME("R");

    private String userInput;

    AvailableInput(String userInput) {
        this.userInput = userInput;
    }

    public static String get(AvailableInput occasion) {
        return occasion.userInput;
    }
}
