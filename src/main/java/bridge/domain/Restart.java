package bridge.domain;

public enum Restart {
    RESTART("R"),
    QUIT("Q");

    private final String status;

    Restart(String status) {
        this.status = status;
    }
}
