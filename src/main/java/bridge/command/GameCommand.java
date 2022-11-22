package bridge.command;

public enum GameCommand {
    RESTART("R", "재시작"),
    QUIT("Q", "종료");
    private final String hotKey;
    private final String explain;

    GameCommand(String hotKey, String explain) {
        this.hotKey = hotKey;
        this.explain = explain;
    }

    public static boolean exist(String name) {
        for (GameCommand gameCommand : GameCommand.values()) {
            if (gameCommand.ofHotKey().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String ofHotKey() {
        return this.hotKey;
    }

}
