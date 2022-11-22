package bridge;

public enum GameCommand {
    RETRY("R"), QUIT("Q");

    private final String value;

    static private final String invalidGameCommandMessage = "게임 재시도 여부는 R 또는 Q를 입력해야 합니다.";

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
        throw new IllegalArgumentException(invalidGameCommandMessage);
    }

    static public boolean isRetry(String value) {
        return RETRY.getValue().equals(value);
    }
}
