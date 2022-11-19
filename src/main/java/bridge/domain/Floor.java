package bridge.domain;

public class Floor {
    private static final String UP_STARE = "U";
    private static final String DOWN_STARE = "D";

    private final String status;

    Floor(String status) {
        validateStatus(status);
        this.status = status;
    }

    private void validateStatus(String status) {
        if (isNotStatus(status)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private boolean isNotStatus(String status) {
        return !UP_STARE.equals(status) && !DOWN_STARE.equals(status);
    }

    public boolean isSafe(String input) {
        validateStatus(input);
        return this.status.equals(input);
    }
}
