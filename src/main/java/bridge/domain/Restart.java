package bridge.domain;

import bridge.exception.InvalidRestartFormatException;

public enum Restart {
    RESTART("R"),
    QUIT("Q");

    private final String status;

    Restart(String status) {
        this.status = status;
    }

    public static void validate(String status) {
        if (status.equals(Restart.RESTART.getStatus())
                || status.equals(Restart.QUIT.getStatus())) {
            return;
        }

        throw new InvalidRestartFormatException();
    }

    public String getStatus() {
        return status;
    }
}
