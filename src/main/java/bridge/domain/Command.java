package bridge.domain;

public enum Command {
    UP(1, "U"),
    DOWN(0, "D");

    private final int statusInteger;
    private final String statusString;

    Command(int statusInteger, String statusString) {
        this.statusInteger = statusInteger;
        this.statusString = statusString;
    }

    public int getStatusInteger() {
        return statusInteger;
    }

    public String getStatusString() {
        return statusString;
    }
}
