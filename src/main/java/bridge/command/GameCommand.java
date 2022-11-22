package bridge.command;

public enum GameCommand {
    RESTART("R", "재시작"),
    QUIT("Q", "종료");
    private final String key;
    private final String value;

    GameCommand(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static boolean exist(String name) {
        for (GameCommand gameCommand : GameCommand.values()) {
            if (gameCommand.getKey().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String getKey() {
        return this.key;
    }

}