package bridge.command;

public enum MoveCommand {
    DOWN("D", "아래"),
    UP("U", "위");
    private final String hotKey;
    private final String explain;

    MoveCommand(String hotKey, String explain) {
        this.hotKey = hotKey;
        this.explain = explain;
    }

    public static boolean exist(String name) {
        for (MoveCommand moveCommand : MoveCommand.values()) {
            if (moveCommand.ofHotKey().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String ofHotKey() {
        return this.hotKey;
    }
}
