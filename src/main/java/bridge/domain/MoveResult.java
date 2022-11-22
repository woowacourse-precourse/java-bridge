package bridge.domain;

public enum MoveResult {
    SUCCESS("O"),
    FAIL("X"),
    NOT_MOVE(" ");

    private final String command;

    MoveResult(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public boolean isFail() {
        return this.equals(FAIL);
    }
}
