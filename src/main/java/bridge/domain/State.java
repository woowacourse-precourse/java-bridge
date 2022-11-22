package bridge.domain;

public enum State {
    ALIVE("O"), NOT_MOVED(" "), DEAD("X");
    private final String status;

    State(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static State getStatusByCrossed(boolean crossed) {
        if (crossed) {
            return ALIVE;
        }
        return DEAD;
    }
}
