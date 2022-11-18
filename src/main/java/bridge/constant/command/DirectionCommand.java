package bridge.constant.command;

public enum DirectionCommand implements Command {
    DOWN(0, "D"),
    UP(1, "U");


    private int key;
    private String value;

    DirectionCommand(int key, String value) {
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
