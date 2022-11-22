package bridge.command;

public enum MoveCommand {
    DOWN("D", "아래"),
    UP("U", "위");
    private final String key;
    private final String value;

    MoveCommand(String key, String value) {
        this.key = key;
        this.value = value;
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
        return this.key;
    }
}