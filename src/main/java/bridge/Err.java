package bridge;

public enum Err {
    WRONG_BRIDGE_LENGTH ("Bridge length should be in range[3, 20]"),
    WRONG_MOVE("You can only move \'U\' or \'D\'"),
    WRONG_RETRY_OR_TERMINATE("Enter \'R\' to retry or \'Q\' to terminate the game");

    private static final String ERROR_MESSAGE = "[ERROR]";
    private String msg;
    Err(String msg) {
        this.msg = msg;
    }

    public void invalid() {
        throw new IllegalArgumentException(ERROR_MESSAGE + ' ' + msg);
    }
}
