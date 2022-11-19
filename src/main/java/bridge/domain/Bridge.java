package bridge.domain;

import java.util.List;
import java.util.Objects;

public class Bridge {

    private final List<String> shapes;

    public Bridge(List<String> shapes) {
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

    @Override
    public String toString() {
        return shapes.toString();
    }
}
