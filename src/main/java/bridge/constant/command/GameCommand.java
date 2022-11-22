package bridge.constant.command;

public enum GameCommand implements Command {
    QUIT(0, "Q"),
    RETRY(1, "R");

    private int key;
    private String value;

    GameCommand(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
}
