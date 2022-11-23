package bridge.domain.vo.enumeration;

public enum GameCommandType {
    RETRY("R"),
    QUIT("Q");

    private final String gameCommandType;

    GameCommandType(String gameCommandType) {
        this.gameCommandType = gameCommandType;
    }

    public String getGameCommandType() {
        return this.gameCommandType;
    }
}
