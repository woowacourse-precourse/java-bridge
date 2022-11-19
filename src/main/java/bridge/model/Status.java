package bridge.model;

public enum Status {
    SURVIVE("O"),
    DIE("X");

    private final String display;

    Status(String display) {
        this.display = display;
    }

    public String getDisplay(Status status) {
        return status.display;
    }

}