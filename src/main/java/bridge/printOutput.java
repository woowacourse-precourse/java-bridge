package bridge;

public enum printOutput {
    MOVE_POSSIBLE("O"),
    MOVIE_IMPOSSIBLE("X"),
    NOT_SELECTED(" "),
    BRIDGE_START("["),
    BRIDGE_END("]"),
    BRIDGE_MIDDLE("|"),
    IS_SUCCESS("게임 성공 여부: "),
    ALL_TRY("총 시도한 횟수: ");
    private final String gameOutput;

    public String getGameOutput() {
        return gameOutput;
    }

    printOutput(String gameOutput) {
        this.gameOutput = gameOutput;
    }
}
