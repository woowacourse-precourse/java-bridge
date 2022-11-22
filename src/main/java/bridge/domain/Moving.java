package bridge.domain;

public enum Moving {
    UP("U", 1),
    DOWN("D", 0);

    private final String direction;
    private final int code;

    Moving(String direction, int code) {
        this.direction = direction;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDirection() {
        return direction;
    }
}
