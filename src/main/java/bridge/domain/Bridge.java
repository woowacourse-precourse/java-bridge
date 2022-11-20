package bridge.domain;

public enum Bridge {
    O(" O "),
    X(" X "),
    BLANK("   ");

    private final String location;

    Bridge(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

}
