package bridge.rule;

public enum MovingOption {

    UP("U"),
    DOWN("D");

    private final String moving;

    MovingOption(String moving) {
        this.moving = moving;
    }

    public static boolean isCorrectMoving(String moving) {
        return UP.moving.equals(moving) || DOWN.moving.equals(moving);
    }
}
