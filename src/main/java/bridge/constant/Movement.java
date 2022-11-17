package bridge.constant;

public enum Movement {
    UP_AND_O(true, true),
    UP_AND_X(true, false),
    DOWN_AND_O(false, true),
    DOWN_AND_X(false, false);

    private boolean isUpper;
    private boolean availability;

    Movement(boolean isUpper, boolean availability) {
        this.isUpper = isUpper;
        this.availability = availability;
    }

    public boolean isUpper() {
        return isUpper;
    }

    public boolean isAvailable() {
        return availability;
    }
}
