package bridge.util.constants;

public enum MovableSpace {
    UPPER_SPACE("U"),
    LOWER_SPACE("D");

    private String value;

    MovableSpace(String space) {
        this.value =space;
    }

    public String getValue() {
        return value;
    }
}
