package bridge.domain.game;

import static bridge.constant.gameValue.DOWN;
import static bridge.constant.gameValue.UP;

public class Direction {

    private static final String DIRECTION_BLANK_ERROR = "입력 값은 비어있을 수 없습니다.";
    private static final String BRIDGE_FORMAT_ERROR = "U 또는 D 만 입력해야합니다.";
    private final String direction;

    public Direction(String direction) {
        validate(direction);
        this.direction = direction;
    }

    private void validate(String direction) {
        checkNotBlank(direction);
        checkFormatValid(direction);
    }

    private void checkNotBlank(String direction) {
        boolean isBlank = direction.isBlank();
        if (isBlank) {
            throw new IllegalArgumentException(DIRECTION_BLANK_ERROR);
        }
    }

    private void checkFormatValid(String direction) {
        boolean isFormatValid = direction.equals(UP) || direction.equals(DOWN);
        if (!isFormatValid) {
            throw new IllegalArgumentException(BRIDGE_FORMAT_ERROR);
        }
    }

    public boolean isSameUp() {
        return direction.equals(UP);
    }

    public boolean isSameDown() {
        return direction.equals(DOWN);
    }

    public boolean isSameDirection(Direction other) {
        return direction.equals(other.direction);
    }
}
