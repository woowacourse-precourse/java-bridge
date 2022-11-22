package bridge.domain;

public enum Status {
    ALIVE("O"), NOT_MOVED(" "), DEAD("X");
    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static Status getStatusByCrossed(boolean crossed) {
        if (crossed) {
            return ALIVE;
        }
        return DEAD;
    }
}
