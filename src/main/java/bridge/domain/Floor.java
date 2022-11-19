package bridge.domain;

public class Floor {
    private final String status;

    Floor(String status) {
        this.status = status;
    }

    public boolean isSafe(String input) {
        return this.status.equals(input);
    }
}
