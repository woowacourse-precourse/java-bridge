package bridge.constant;

public enum Movement {
    UP_AND_O(true),
    UP_AND_X(false),
    DOWN_AND_O(true),
    DOWN_AND_X(false);

    private final boolean availability;

    Movement(boolean availability) {
        this.availability = availability;
    }

    public boolean isAvailable() {
        return availability;
    }
}
