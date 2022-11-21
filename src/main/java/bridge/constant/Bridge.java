package bridge.constant;

public enum Bridge {
    O(" O "),
    X(" X "),
    BLANK("   ");

    private final String location;

    private Bridge(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

}
