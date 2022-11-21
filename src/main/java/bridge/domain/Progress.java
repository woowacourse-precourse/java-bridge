package bridge.domain;

public enum Progress {
    RETRY("R"),
    QUIT("Q");

    private String command;

    Progress(String command) {
        this.command = command;
    }

    public String toString() {
        return command;
    }
}
