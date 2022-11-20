package bridge;

public enum printOutput {
    MOVE_POSSIBLE("O"),
    MOVIE_IMPOSSIBLE("X"),
    NOT_SELECTED(" "),
    BRIDGE_START("["),
    BRIDGE_END("]"),
    BRIDGE_MIDDLE("|");
    private final String gameOutput;

    public String getGameOutput() {
        return gameOutput;
    }

    printOutput(String gameOutput) {
        this.gameOutput = gameOutput;
    }
}
