package bridge.model;

public class BridgeMoving {

    private final String moving;

    public BridgeMoving(String moving) {
        validateBridgeMoving(moving);
        this.moving = moving;
    }

    public void validateBridgeMoving(String moving) {
        if (isMovingFormatCorrect(moving)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 이동할 칸은 U,D 이어야만 합니다.");
    }

    private static boolean isMovingFormatCorrect(String moving) {
        return moving.equals("U") || moving.equals("D");
    }

}
