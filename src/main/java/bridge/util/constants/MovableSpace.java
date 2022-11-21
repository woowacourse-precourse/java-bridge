package bridge.util.constants;

public enum MovableSpace {
    UP_SPACE("U"),
    DOWN_SPACE("D");

    private String value;

    MovableSpace(String space) {
        this.value =space;
    }

    public String getValue() {
        return value;
    }
}
