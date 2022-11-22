package bridge;

public enum SiteAvailability {
    ACCESS_UP_SITE(1),
    ACCESS_DOWN_SITE(0);

    private final int availability;

    SiteAvailability(int availability) {
        this.availability = availability;
    }

    public boolean isSameValue(int value) {
        return this.availability == value;
    }
}
