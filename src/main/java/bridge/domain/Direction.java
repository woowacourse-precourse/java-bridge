package bridge.domain;

import java.util.Arrays;

import static bridge.utils.ErrorMessages.ERROR_INVALID_BRIDGE_NUMBER;
import static bridge.utils.ErrorMessages.ERROR_INVALID_MOVING;

public enum Direction {
    UP("U", 0),
    DOWN("D", 1);

    private final String shape;
    private final int shapeNumber;

    Direction(String shape, int shapeNumber) {
        this.shape = shape;
        this.shapeNumber = shapeNumber;
    }

    public static Direction of(String shape) {
        return Arrays.stream(values())
                .filter(direction -> direction.shape.equals(shape))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_MOVING));
    }

    public static Direction of(int shapeNumber) {
        return Arrays.stream(values())
                .filter(shape -> shape.shapeNumber == shapeNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_BRIDGE_NUMBER));
    }
}
