package bridge.Utils.Constant;

public enum Moving {
    UP("U"),
    DOWN("D");

    private final String moving;

    Moving(String moving) {
        this.moving = moving;
    }

    @Override
    public String toString() {
        return moving;
    }
}
