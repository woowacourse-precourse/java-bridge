package bridge.domain.enums;

public enum Moving {
    UP("U"),
    DOWN("D");

    private final String moving;

    Moving(String moving) {
        this.moving = moving;
    }

    public String getValue() {
        return moving;
    }
}
