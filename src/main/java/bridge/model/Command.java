package bridge.model;

public enum Command {
    RETRY("R"),
    END("Q");

    private final String name;

    Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
