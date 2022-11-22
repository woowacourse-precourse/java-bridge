package bridge.data;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private final String label;

    Command(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
