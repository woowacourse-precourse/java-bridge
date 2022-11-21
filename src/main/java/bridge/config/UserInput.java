package bridge.config;

public enum UserInputConfig {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private final String value;

    UserInputConfig(String value) {
        this.value = value;
    }

    public boolean isUD(String userInput) {
        return false;
    }
}
