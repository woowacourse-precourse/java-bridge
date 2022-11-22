package bridge.domain;

public class MoveDirection {

    private static final String INVALID_MOVING_SIGN_MESSAGE = "[ERROR] 이동할 칸은 U또는 D만 입력 가능합니다";
    private static final String UP_SIGN = "U";
    private static final String DOWN_SIGN = "D";
    private final String direction;

    public MoveDirection(String direction) {
        validateDirection(direction);
        this.direction = direction;
    }

    private void validateDirection(String direction) {
        if (direction.equals(UP_SIGN) || direction.equals(DOWN_SIGN)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_MOVING_SIGN_MESSAGE);
    }

    public boolean isEqualTo(String answer) {
        return this.direction.equals(answer);
    }
}
