package bridge.domain;

import java.util.List;
import java.util.Objects;

public class Bridge {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String SIZE_ERROR = "다리 길이는 " + MIN_SIZE + "부터 " + MAX_SIZE + "까지 가능합니다.";

    private final List<String> shapes;

    public Bridge(List<String> shapes) {
        validateSize(shapes.size());
        this.shapes = shapes;
    }

    public int getSize() {
        return shapes.size();
    }

    public boolean isPossibleMoving(int play, String moving) {
        return findShape(play).equals(moving);
    }

    private String findShape(int play) {
        return shapes.get(play);
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
        return Objects.equals(shapes, bridge.shapes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapes);
    }
}
