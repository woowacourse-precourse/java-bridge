package bridge.domain.vo;

import bridge.domain.enumeration.MovingType;

import static bridge.domain.enumeration.MovingType.*;

public class Moving {
    private static final String MOVING_LENGTH_IS_NOT_ONE = "[ERROR] 이동할 칸은 문자 1개를 입력해주세요.";
    private static final String MOVING_IS_NOT_U_AND_D = "[ERROR] 이동할 칸은 U 또는 D로 입력해주세요.";

    private final String moving;

    public static Moving createMoving(String moving) {
        return new Moving(moving);
    }

    public Moving(String moving) {
        validateMoving(moving);
        this.moving = moving;
    }

    public String getMoving() {
        return this.moving;
    }

    public void validateMoving(String moving) {
        if (moving.length() != 1) {
            throw new IllegalArgumentException(MOVING_LENGTH_IS_NOT_ONE);
        }
        if (!moving.equals(UP.getMovingType()) && !moving.equals(DOWN.getMovingType())) {
            throw new IllegalArgumentException(MOVING_IS_NOT_U_AND_D);
        }
    }
}
