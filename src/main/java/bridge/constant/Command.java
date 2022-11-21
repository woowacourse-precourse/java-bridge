package bridge.constant;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private String description;

    Command(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
