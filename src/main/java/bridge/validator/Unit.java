package bridge.validator;

public enum Unit {
    BRIDGE_MINIMUM_SIZE(3),
    BRIDGE_MAXIMUM_SIZE(20),
    UP ("U"),
    DOWN ("D"),
    RETRY ("R"),
    QUITE ("Q");

    private int size;
    private String command;

    Unit(int size) {
        this.size = size;
    }

    Unit(String command) {
        this.command = command;
    }

    public int getSize() {
        return size;
    }

    public String getCommand() {
        return command;
    }
}
