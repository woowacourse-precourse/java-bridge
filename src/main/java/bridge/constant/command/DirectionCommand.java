package bridge.constant.command;

public enum DirectionCommand implements Command{
    UP(0, "U"),
    DOWN(1, "D");

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
