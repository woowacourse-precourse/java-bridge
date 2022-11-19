package bridge.domain;

import java.util.List;
import java.util.Objects;

public class Bridge {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String SIZE_ERROR = "다리 길이는 " + MIN_SIZE + "부터 " + MAX_SIZE + "까지 가능합니다.";

    private final List<String> shape;

    public Bridge(List<String> shape) {
        validateSize(shape.size());
        this.shape = shape;
    }

    public int getSize() {
        return shape.size();
    }

    public boolean canMove(int place, String moving) {
        return findShape(place).equals(moving);
    }

    private String findShape(int place) {
        return shape.get(place);
    }

    private void validateSize(int size) {
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bridge bridge = (Bridge) o;
        return Objects.equals(shape, bridge.shape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape);
    }
}
