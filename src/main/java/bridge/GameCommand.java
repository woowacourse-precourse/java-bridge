package bridge;

public enum GameCommand {
    RETRY("R"), QUIT("Q");

    private final String value;

    GameCommand(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    static public GameCommand getGameCommand(String value) {
        for (GameCommand gameCommand : GameCommand.values()) {
            if (gameCommand.getValue().equals(value)) {
                return gameCommand;
            }
        }
        throw new IllegalArgumentException("잘못된 게임 명령입니다.");
    }

    static public boolean isRetry(String value) {
        return RETRY.getValue().equals(value);
    }
}
